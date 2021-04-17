import BaseStore from "./BaseStore";
import { action, makeObservable, observable } from "mobx";
import { requestQuestions } from "../api/questions";

class QuestionsStore extends BaseStore {

    @observable
    elementsMap = new Map(); // key - id, value - ans

    constructor() {
        super()
        makeObservable(this, {
            loading: observable,
            loaded: observable,
            data: observable,
            elementsMap: observable,
            loadDataSuccess: action.bound,
            loadDataError: action.bound,
            loadData: action.bound,
            loadQuestions: action.bound,
            createQuestion: action.bound,
            deleteQuestion: action.bound,
            refreshQuestions: action.bound, 
            set: action.bound
        });
    }

    @action.bound
    set(key, value) {
        return this.elementsMap.set(key, value)
    }

    @action.bound
    loadQuestions(pollId) {
        const rest = (() => requestQuestions(pollId))
        return this.loadData(rest)
    }

    @action.bound
    refreshQuestions(pollId) {
        const rest = (() => requestQuestions(pollId))
        return this.refreshData(rest)
    }

    @action
    createQuestion(question) {
        return requestCreatePoll(question)
    }

    @action
    deleteQuestion(question) {
        return requestDeletePoll(question)
    }
}

export default QuestionsStore;