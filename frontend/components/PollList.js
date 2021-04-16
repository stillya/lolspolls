import React from 'react';
import { useCallback, useEffect, useState } from "react";
import PollsStore from "../stores/PollsStore";
import { View, Text, ScrollView, StyleSheet, SafeAreaView } from 'react-native';
import { observer, useLocalStore, useObserver } from 'mobx-react';
import PollElement from './PollElement';
import { Container, Spinner } from 'native-base';
import MainSpinner from './commons/MainSpinner';
import MainHeader from './commons/MainHeader';

function PollList(props) {
  // stores

  const pollsStore = useLocalStore(
    () => new PollsStore())

  // values

  const [creationModalOpened, setCreationModalOpened] = useState(false)
  const [updateModalOpened, setUpdateModalOpened] = useState(false)

  // change handlers

  const handleCreatePoll = useCallback((poll) => {
    return pollsStore.createPoll(poll).then(() => {
      pollsStore.loadPolls()
      setCreationModalOpened(false)
    })
  })

  // life cycle

  useEffect(() => {
    pollsStore.loadPolls();
  }, [])

  return useObserver(() => {
    console.log(pollsStore.loaded)
    return (
      <View>
        <MainHeader />
        {pollsStore.loaded ?

          <ScrollView>
            {pollsStore.data.map((item) => (
              <PollElement data={item} />
            ))}
          </ScrollView>

          :
          <MainSpinner />
        }
      </View>
    )
  })
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#F2F2F2',
    paddingTop: 40,
    paddingHorizontal: 20,
  }
});

export default PollList;