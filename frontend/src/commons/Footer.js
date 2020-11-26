import React from "react";
import styled from "styled-components/macro";
import { SiGooglemaps } from "react-icons/si";
import { MdFilterList } from "react-icons/md";
import { IconButtonStyled } from "../styling/IconButtonStyled";

export default function Footer() {
  return (
    <FooterStyled>
      <IconButtonStyled>
        <MdFilterList size={40} />
      </IconButtonStyled>
      <IconButtonStyled>
        <SiGooglemaps size={35} />
      </IconButtonStyled>
    </FooterStyled>
  );
}

const FooterStyled = styled.div`
  display: grid;
  grid-template-columns: 30% 1fr 30%;
  align-items: center;
  justify-items: center;
  background-color: var(--turquoise-main);
  color: var(--white-main);

  button:last-child {
    grid-column-start: 3;
  }
`;
