import axios from 'axios'

const uri = process.env.REACT_APP_API_URI + process.env.REACT_APP_API_PREFIX

export function requestPolls() { 
    return axios
        .get(
        uri + '/poll'
        ).then((request) => request.data)
}

export function requestCreatePoll(poll) {
    return axios
        .post(
            uri + '/poll', {...poll}
        ).then((request) => request.data)
}

export function requestUpdatePoll(poll) { 
    return axios
        .put(
            uri + '/poll/update/' + poll.id, 
            {...poll}
        ).then((request) => request.data)
}

export function requestDeletePoll(poll) {
    return axios
        .delete(
            uri + '/poll/' + poll.id, 
            {...poll}
        ).then((request) => request.data)
}