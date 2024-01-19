package bitcamp.myapp;

import bitcamp.RequestException;
import bitcamp.myapp.dao.json.AssignmentDaoImpl;
import bitcamp.myapp.dao.json.BoardDaoImpl;
import bitcamp.myapp.dao.json.MemberDaoImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerApp02 {

  HashMap<String, Object> daoMap = new HashMap<>();
  Gson gson;

  public ServerApp02() {
    daoMap.put("board", new BoardDaoImpl("board.json"));
    daoMap.put("greeting", new BoardDaoImpl("greeting.json"));
    daoMap.put("assignment", new AssignmentDaoImpl("assignment.json"));
    daoMap.put("member", new MemberDaoImpl("member.json"));

    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  public static void main(String[] args) {
    new ServerApp02().run();
  }

  void run() {
    System.out.println("[과제관리 서버시스템]");

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      // 1) 랜카드 연결 정보를 준비한다.
      // => 랜카드와 연결하는 것은 실제 OS가 수행한다.
      // => JVM은 OS가 작업한 결과를 가져온다.
      // new ServerSocket(포트번호)
      // = > 포트번호: 외부에서 랜카드로 들어온 데이터를 받을 때 사용할 식별 번호. 중복 불가.

      System.out.println("서버 실행!");

      while (true) {

        new Thread(new RequestProcessor(serverSocket.accept())).start();
      }

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void service(Socket socket) {
    try (Socket s = socket; // 자동으로 close 해줌
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {

      System.out.println("클라이언트와 연결됨!");

      processRequest(in, out);

      System.out.println("클라이언트 연결 종료!");

    } catch (Exception e) {
      System.out.println("클라이언트 연결 오류!");
    }
  }

  void processRequest(DataInputStream in, DataOutputStream out) throws IOException {

    System.out.println("[클라이언트 요청]");
    String dataName = in.readUTF(); // 클라이언트가 요청할 때는 3개의 값을 읽음
    String command = in.readUTF();
    String value = in.readUTF();

    try {
      // dataName으로 DAO를 찾는다.
      Object dao = daoMap.get(dataName);
      if (dao == null) {
        throw new RequestException("요청 데이터가 없습니다!");
      }
      System.out.printf("데이터: %s\n", dataName);

      Method commandHandler = findMethod(dao.getClass(), command);//dao클래스에서 command이름으로 메서드를 찾음
      System.out.printf("메서드: %s\n", commandHandler.getName());

      Object[] args = getArguments(commandHandler, value);

      // 메서드의 리턴 타입을 알아낸다.
//      Class<?> returnType = commandHandler.getReturnType();
//      System.out.printf("리턴: %s\n", returnType.getName());

      // 메서드를 호출한다.
      Object returnValue = commandHandler.invoke(dao, args);

      out.writeUTF("200"); // 문제가 없을때
      out.writeUTF(gson.toJson(returnValue));// 리턴 결과를 클라이언트에게 보낸다.
      System.out.println("클라이언트에게 응답 완료!");

    } catch (RequestException e) {
      out.writeUTF("400"); // 요청에 문제가 발생할때 이렇게 처리함
      out.writeUTF(gson.toJson(e.getMessage()));

    } catch (Exception e) {
      out.writeUTF("500"); // 처리하다가 문제가 발생할때 이렇게 처리함
      out.writeUTF(gson.toJson(e.getMessage()));
    }
  }

  Method findMethod(Class<?> clazz, String name) { // 클래스 정보가 주어졌을때 그 이름으로 어떻게 메서드를 찾는지
    Method[] methods = clazz.getDeclaredMethods();
    //getDeclaredMethods하면 현재 클래스에 선언된 메서드 목록을 배열로 다 리턴함
    for (Method m : methods) {
      if (m.getName().equals(name)) {
        return m;
      }
    }
    throw new RequestException("요청 메서드가 없습니다!");
  }

  Object[] getArguments(Method m, String json) { // 아규먼트를 어떻게 준비하는지
    // 메서드의 파라미터 정보를 알아낸다.
    Parameter[] params = m.getParameters();
    System.out.printf("파라미터 개수: %d\n", params.length);
    // 메서드를 호출할 대 파라미터에 넘겨 줄 데이터를 담을 배열을 준비한다.
    Object[] args = new Object[params.length];
    // 아규먼트 값 준비하기
    // => 현재 모든 DAO의 메서드는 파라미터가 최대 1개만 있다.
    // => 1개만 있다는 가정하에서 아규먼트 값을 준비한다.
    if (params.length > 0) {
      // 파라미터 타입을 알아낸다.
      Class<?> paramType = params[0].getType();
      // 클라이언트가 보낸 JSON 문자열을 해당 파라미터 타입 객체로 변환한다.
      Object paramValue = gson.fromJson(json, paramType);
      // 아규면트 배열에 저장한다.
      args[0] = paramValue;
    }

    return args;
  }

  // non-staric nestes class(inner class)는 바깥 클래스(enclosing class)의 인스턴스 주소를
  // 자동으로 받는다. => 바깥 클래스의 인스턴스 멤버를 자기거 처럼 사용할 수 있다.
  class RequestProcessor implements Runnable {

    Socket socket;

    RequestProcessor(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try {
        ServerApp02.this.service(socket);
      } catch (Exception e) {
        System.out.println("클리이언트 요청 처리 중 오류 발생!");
        e.printStackTrace();
      }
    }
  }
}

