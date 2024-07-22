import Post from "./Post";
import classes from "./PostList.module.css";

function PostList() {
  return (
    <ul className={classes.posts}>
      <Post author="Maximilian" body="React.js is awesom!" />
      <Post author="Manuel" body="Check out the full course!" />
    </ul>
  );
}

export default PostList;
