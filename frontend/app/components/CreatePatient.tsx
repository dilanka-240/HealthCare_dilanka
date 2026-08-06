import React, { useState } from 'react';
import { View, Text, TextInput, Button, Alert, StyleSheet } from 'react-native';
import { Picker } from '@react-native-picker/picker';
import { createPatient } from '../api/patientApi';

export default function CreatePatient() {
  const [patient, setPatient] = useState({
    name: '',
    birthday: '',
    sex: '',
    occupation: '',
    allergies: '',
  });

  const handleChange = (field: string, value: string) => {
    setPatient({ ...patient, [field]: value });
  };

  const handleSubmit = async () => {
    try {
      await createPatient(patient);
      Alert.alert('Success', 'Patient created successfully');
      setPatient({
        name: '',
        birthday: '',
        sex: '',
        occupation: '',
        allergies: '',
      });
    } catch (err) {
      console.error(err);
      Alert.alert('Error', 'Something went wrong');
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Create Patient</Text>
      <TextInput
        placeholder="Name"
        value={patient.name}
        onChangeText={t => handleChange('name', t)}
        style={styles.input}
      />
      <TextInput
        placeholder="Birthday (YYYY-MM-DD)"
        value={patient.birthday}
        onChangeText={t => handleChange('birthday', t)}
        style={styles.input}
      />
      <Picker
        selectedValue={patient.sex}
        onValueChange={v => handleChange('sex', v)}
        style={styles.input}
      >
        <Picker.Item label="Select Gender" value="" />
        <Picker.Item label="Male" value="MALE" />
        <Picker.Item label="Female" value="FEMALE" />
      </Picker>
      <TextInput
        placeholder="Occupation"
        value={patient.occupation}
        onChangeText={t => handleChange('occupation', t)}
        style={styles.input}
      />
      <TextInput
        placeholder="Allergies"
        value={patient.allergies}
        onChangeText={t => handleChange('allergies', t)}
        style={styles.input}
      />
      <Button title="Create" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20 },
  title: { fontSize: 20, marginBottom: 10 },
  input: { borderWidth: 1, borderColor: '#ccc', padding: 8, marginBottom: 10 },
});