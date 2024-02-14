import { Component } from "react";
import ErrorMessage from "./ErrorMessage";

class ErrorProcess extends Component {
  state = {
    error: false,
    message: "",
  };

  componentDidCatch(error, info) {
    this.setState({
      error: true,
      message: error.message,
    });

    console.error(error, info);
  }

  render() {
    const { error, message } = this.state;
    return error ? <ErrorMessage>{message}</ErrorMessage> : this.props.children;
  }
}

export default ErrorProcess;
