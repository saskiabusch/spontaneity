import React, { useContext } from "react";
import UserContext from "../contexts/UserContext";
import { Route, Redirect } from "react-router-dom";

export default function ProtectedRoute(props) {
  const { tokenIsValid } = useContext(UserContext);
  return tokenIsValid() ? <Route {...props} /> : <Redirect to="/login" />;
}
