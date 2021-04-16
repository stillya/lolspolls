import React from 'react';
import { useCallback, useEffect, useState } from "react";
import PollsStore from "../stores/PollsStore";
import { View, Text, ScrollView, StyleSheet, SafeAreaView, RefreshControl } from 'react-native';
import { observer, useLocalStore, useObserver } from 'mobx-react';
import PollElement from './PollElement';
import { Container, Spinner } from 'native-base';
import MainSpinner from './commons/MainSpinner';
import MainHeader from './commons/MainHeader';
import { useHistory } from 'react-router';

function PollList(props) {
  // stores

  const pollsStore = useLocalStore(
    () => new PollsStore())

  // values

  const [refreshing, setRefreshing] = useState(false);
  const [creationModalOpened, setCreationModalOpened] = useState(false)
  const [updateModalOpened, setUpdateModalOpened] = useState(false)

  // change handlers

  const handleCreatePoll = useCallback((poll) => {
    return pollsStore.createPoll(poll).then(() => {
      pollsStore.loadPolls()
      setCreationModalOpened(false)
    })
  })

  const handleUpdatePoll = useCallback(() => {
    setRefreshing(true);
    pollsStore.refreshPolls()
    setRefreshing(false)
  }, [pollsStore])


  // life cycle

  useEffect(() => {
    pollsStore.loadPolls();
  }, [])

  return useObserver(() => {
    return (
      <View styles={styles.container}>

        <MainHeader />

        {pollsStore.loaded ?

          <RefreshControl style={{ marginBottom: 100 }}
            refreshing={refreshing}
            onRefresh={handleUpdatePoll}>

            <ScrollView>
              {pollsStore.data.map((item) => (
                <PollElement data={item} />
              ))}
            </ScrollView>
            
          </RefreshControl>

          :
          <MainSpinner />
        }

      </View>
    )
  })
}

const styles = StyleSheet.create({
  container: {
  }
});

export default PollList;