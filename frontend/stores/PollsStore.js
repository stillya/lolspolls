import { action } from "mobx";
import { requestCreatePoll, requestDeletePoll, requestPolls } from "../api/polls";
import BaseStore from "./BaseStore";


class PollsStore extends BaseStore { 

    @action
    loadPolls() {
        const rest = () => requestPolls()
        return this.loadData(rest)
    }

    @action 
    createPoll(poll) { 
        return requestCreatePoll(poll)
    }

    @action
    deletePoll(poll) { 
        return requestDeletePoll(poll)
    }
}

export default PollsStore