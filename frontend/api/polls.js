import axios from 'axios'

const uri = "http://535d24d7b47a.ngrok.io/api"

export function requestPolls() {
    return axios
        .get(
            uri + '/poll'
        ).then((response) => {
            console.log(response.data);
            return response.data
        })
}

export function requestCreatePoll(poll) {
    return axios
        .post(
            uri + '/poll', { ...poll }
        ).then((response) => response.data)
}

export function requestUpdatePoll(poll) {
    return axios
        .put(
            uri + '/poll/update/' + poll.id,
            { ...poll }
        ).then((response) => response.data)
}

export function requestDeletePoll(poll) {
    return axios
        .delete(
            uri + '/poll/' + poll.id,
            { ...poll }
        ).then((response) => response.data)
}