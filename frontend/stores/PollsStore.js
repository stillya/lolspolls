const { action } = require("mobx");
const { requestElements } = require("../api/elements");


class PollsStore extends BaseStore { 

    @action
    loadPolls() { 
        return requestElements()
    }
}