import React from "react";
import { Switch, Route } from "react-router-dom";
import LoginPage from "./security/LoginPage";
import PostsToday from "./postsPages/PostsToday";
import UserContextProvider from "./contexts/UserContextProvider";
import ProtectedRoute from "./routing/ProtectedRoute";
import SignUpPage from "./security/SignUpPage";

function App() {
  return (
    <UserContextProvider>
      <Switch>
        <Route path="/login">
          <LoginPage />
        </Route>
        <Route path="signup">
          <SignUpPage />
        </Route>
        <ProtectedRoute path={["/", "/home"]}>
          <PostsToday />
        </ProtectedRoute>
      </Switch>
    </UserContextProvider>
  );
}

export default App;
