import styled from "styled-components";
import { buttonSizes, fontSizes } from "../../styles/size";
import color from "../../styles/color";

const { small, medium, big } = buttonSizes;
const { small: fSmall, medium: fMedium, big: fBig } = fontSizes;

export const SmallButton = styled.button`
  width: ${small.width}px;
  height: ${small.height}px;
  font-size: ${fSmall}rem;
  background: ${({ bcolor }) => color[bcolor] || bcolor};
  color: ${({ color }) => color[color] || color};
`;

export const MediumButton = styled.button`
  width: ${medium.width}px;
  height: ${medium.height}px;
  font-size: ${fMedium}rem;
  background: ${({ bcolor }) => color[bcolor] || bcolor};
  color: ${({ color }) => color[color] || color};
`;

export const BigButton = styled.button`
  width: ${big.width}px;
  height: ${big.height}px;
  font-size: ${fBig}rem;
  background: ${({ bcolor }) => color[bcolor] || bcolor};
  color: ${({ color }) => color[color] || color};
`;
