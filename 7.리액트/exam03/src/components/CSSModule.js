import { useState } from "react";
import styles from "./CSSModule.module.scss";
//import classNames from 'classnames';
import classNames from "classnames/bind";
const cx = classNames.bind(styles);

const CSSModule = ({ name }) => {
  const [active, setActive] = useState(false);

  return (
    <>
      <header className={cx("wrap", { on: active })}>
        반갑습니다.
        <span className="title">{name}</span>님..
      </header>
      <button type="button" onClick={() => setActive(!active)}>
        클릭!
      </button>
    </>
  );
};

export default CSSModule;
