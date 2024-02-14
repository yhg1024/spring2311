import React from "react";
import { SmallButton, BigButton } from "./commons/StyledButton";

const LoginForm = () => {
  return (
    <>
      <h1>로그인</h1>
      <form>
        <input type="text" name="userId" placeholder="아이디" />
        <input type="password" name="password" placeholder="비밀번호" />
        <LoginButton type="submit">로그인</LoginButton>
      </form>
    </>
  );
};

export default React.memo(LoginForm);
