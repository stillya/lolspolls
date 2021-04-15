import React from 'react';
import { useCallback, useEffect, useState } from "react";
import PollsStore from "../stores/PollsStore";
import { View, Text, ScrollView, StyleSheet, SafeAreaView } from 'react-native';
import { observer, useLocalStore, useObserver } from 'mobx-react';
import PollElement from './PollElement';

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
      <View style={styles.container}>
        {pollsStore.loaded ?

          <ScrollView>
            {pollsStore.data.map((item) => (
              <PollElement data={item} />
            ))}
          </ScrollView>

          : <Text>Loading...</Text>}
      </View>
    )
  })
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    paddingTop: 40,
    paddingHorizontal: 20
  }
});

export default PollList;