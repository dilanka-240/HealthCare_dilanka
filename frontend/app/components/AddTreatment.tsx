import React, {useState} from "react";
import {   View, Text, TextInput, Button, Alert, StyleSheet} from "react-native";
import { addTreatmentApi } from '../api/TreatmentApi';


export default function AddTreatment () {
  const [treat, setTreat] = useState({
    treatId: "",
    no: "",
    treat_date: "",
    treat_details: ""

  });

  const handleChange = (field: string, value: string) => {
    setTreat({...treat, [field]: value});
  };

  const handleSubmit = async() => {
    try{
      await addTreatmentApi(treat);
      Alert.alert("Succuess", "Add treatment successfully!");
      setTreat({treatId:"", no:"", treat_date:"", treat_details: ""});
    }catch(err){
      console.error(err);
      Alert.alert("Error", "Add treatment failed");
    }
  }

  return(
    <View style={styles.container}>
      <Text style={styles.title}>Add Treatment</Text>

      <TextInput
        placeholder="No"
        value={treat.no}
        onChangeText={(t) => handleChange("no", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Treat ID"
        value={treat.treatId}
        onChangeText={(t) => handleChange("treatId", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Date (YYYY-MM-DD)"
        value={treat.treat_date}
        onChangeText={(t) => handleChange("treat_date", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Treat Details"
        value={treat.treat_details}
        onChangeText={(t) => handleChange("treat_details", t)}
        style={styles.input}
      />

      <Button title="Add Treatment" onPress={handleSubmit} />
    </View>
  );

}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    backgroundColor: '#fff',
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    marginBottom: 15,
    borderRadius: 5,
  },
});

