import React from 'react';
import { Switch, Redirect, Route } from "react-router";
import Poll from "../components/Poll";
import PollList from "../components/PollList";
import QuestionList from "../components/QuestionList";


function Routes() {
    return (
        <Switch>
            <Route path="/polls">
                <PollList/>
            </Route>
            <Route path="/polls/:pollId">
                <Poll/>
            </Route>
            <Route path="/questions">
                <QuestionList/>
            </Route>
            <Route exact path="/">
                <Redirect to="/polls" />
            </Route>
        </Switch>
    )
}

export default Routes;