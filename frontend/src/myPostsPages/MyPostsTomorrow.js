import React, { useContext } from "react";
import PostContext from "../contexts/PostContext";
import { getDate } from "../utils/DateUtils";
import SpontaneityHeader from "../commons/navigation/SpontaneityHeader";
import NavigationHeader from "../commons/navigation/NavigationHeader";
import PostList from "../commons/PostList";
import FooterMyPosts from "../myPostCommons/FooterMyPosts";

export default function MyPostsToday() {
  const { myPosts } = useContext(PostContext);
  const myPostsFiltered = myPosts.filter(
    (myPost) => myPost.localDate === getDate(1)
  );
  return (
    <>
      <SpontaneityHeader />
      <NavigationHeader
        title={"My Posts"}
        day={"Tomorrow"}
        postType={"myposts"}
      />
      <PostList posts={myPostsFiltered} />
      <FooterMyPosts />
    </>
  );
}