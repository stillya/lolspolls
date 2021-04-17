import React from 'react';
import { Switch, Redirect, Route } from "react-router";
import PollList from "../components/PollList";
import QuestionList from "../components/QuestionList";


function Routes() {
    return (
        <Switch>
            <Route path="/polls">
                <PollList />
            </Route>
            <Route path="/poll/:pollId">
                <QuestionList />
            </Route>
            <Route exact path="/">
                <Redirect to="/polls" />
            </Route>
        </Switch>
    )
}

export default Routes;