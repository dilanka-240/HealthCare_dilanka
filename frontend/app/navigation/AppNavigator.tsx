import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import CreatePatient from '../components/CreatePatient';
import AddExamination from '../components/AddExamination.tsx';
import AddTreatment from '../components/AddTreatment.tsx';
import ShowPatientInfo from '../components/ShowPatientInfo';

const Stack = createStackNavigator();

export default function AppNavigator() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Show Patient Info" component={ShowPatientInfo} />
        <Stack.Screen name="Create Patient" component={CreatePatient} />
        <Stack.Screen name="Add Examination" component={AddExamination} />
        <Stack.Screen name="Add Treatment" component={AddTreatment} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
