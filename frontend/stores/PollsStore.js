import { action, makeAutoObservable, makeObservable, observable } from "mobx";
import { requestCreatePoll, requestDeletePoll, requestPolls } from "../api/polls";
import BaseStore from "./BaseStore";


class PollsStore extends BaseStore {

    constructor() {
        super()
        makeObservable(this, {
            loading: observable,
            loaded: observable,
            data: observable,
            loadDataSuccess: action.bound,
            loadDataError: action.bound,
            loadData: action.bound,
            loadPolls: action.bound,
            createPoll: action.bound,
            deletePoll: action.bound,
        });
    }

    @action.bound
    loadPolls() {
        const rest = (() => requestPolls())
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