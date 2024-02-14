import LifeCycle from "./components/LifeCycle";
import { useState } from "react";

const App = () => {
  const [color, setColor] = useState("black");

  return (
    <>
      <LifeCycle color={color} />
      <button type="button" onClick={() => setColor("red")}>
        RED
      </button>
      <button type="button" onClick={() => setColor("blue")}>
        BLUE
      </button>
      <button type="button" onClick={() => setColor("orange")}>
        ORANGE
      </button>
    </>
  );
};

export default App;
