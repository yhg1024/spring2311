import styled from "styled-components";
import { buttonSizes } from "../../style/size";

const { small, medium, big } = buttonSizes;

export const SmallButton = styled.button`
  width: ${small.width}px;
  height: ${small.height}px;
`;

export const MediumButton = styled.button`
  width: ${medium.width}px;
  height: ${medium.height}px;
`;

export const BigButton = styled.button`
  width: ${big.width}px;
  height: ${big.height}px;
`;
