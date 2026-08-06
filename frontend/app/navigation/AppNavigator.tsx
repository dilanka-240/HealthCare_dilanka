import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import CreatePatient from '../components/CreatePatient';

const Stack = createStackNavigator();

export default function AppNavigator() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Create Patient" component={CreatePatient} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
