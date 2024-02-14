import { useState, useEffect } from "react";

const Posts = () => {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((res) => res.json())
      .then((posts) => {
        setItems(posts);
        setLoading(false);
      });
  }, []);

  return (
    <>
      <h1>게시글 목록</h1>
      <ul>
        {loading && <div>loading....</div>}
        {items && items.map(({ id, title }) => <li key={id}>{title}</li>)}
      </ul>
    </>
  );
};

export default Posts;
