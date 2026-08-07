import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import CreatePatient from '../components/CreatePatient';
import AddExamination from '../components/AddExamination.tsx';

const Stack = createStackNavigator();

export default function AppNavigator() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Create Patient" component={CreatePatient} />
        <Stack.Screen name={"Add Examination"} component={AddExamination} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
