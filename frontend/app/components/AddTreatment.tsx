import React, {useState} from "react";
import {   View, Text, TextInput, Button, Alert, StyleSheet} from "react-native";
import {addTreatment} from "../api/TreatmentApi";


export default function addTreatment () {

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
      await addTreatment(treat);
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

      <Button title="Add Examination" onPress={handleSubmit} />
    </View>
  );
}

