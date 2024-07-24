import { useLoaderData } from "react-router-dom";

import Post from "./Post";
import classes from "./PostList.module.css";

function PostList() {
  const posts = useLoaderData();

  return (
    <>
      {posts.length > 0 && (
        <ul className={classes.posts}>
          {posts.map((post) => (
            <Post
              key={post.id}
              id={post.id}
              author={post.author}
              body={post.body}
            />
          ))}
        </ul>
      )}
      {posts.length === 0 && (
        <div style={{ textAlign: "center", color: "white" }}>
          <h2>포스트가 없습니다</h2>
          <p>포스트를 작성해 보세요</p>
        </div>
      )}
    </>
  );
}

export default PostList;
