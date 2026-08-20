import React, { useState, useEffect, useCallback } from 'react';
import {
  View,
  Text,
  TextInput,
  TouchableOpacity,
  ScrollView,
  ActivityIndicator,
  Alert,
  StyleSheet,
  RefreshControl,
} from 'react-native';
import { getPatientInfo } from '../api/PatientApi';

export interface Examination {
  examId?: number;
  exam_date?: string;
  bp?: number;
  hp?: number;
  wi?: number;
  temp?: number;
}

export interface Treatment {
  treatId?: number;
  treat_date?: string;
  treat_details?: string;
}

export interface PatientInformation {
  name: string;
  birthday: string;
  sex: string;
  occupation: string;
  allergies: string;
  examination?: Examination[];
  treatment?: Treatment[];
}

interface ShowPatientInfoProps {
  route?: {
    params?: {
      no?: string | number;
      patientNo?: string | number;
    };
  };
  navigation?: any;
}

export default function ShowPatientInfo({ route }: ShowPatientInfoProps) {
  const [patientNo, setPatientNo] = useState<string>('');
  const [patientInfo, setPatientInfo] = useState<PatientInformation | null>(null);
  const [loading, setLoading] = useState<boolean>(false);
  const [refreshing, setRefreshing] = useState<boolean>(false);
  const [hasSearched, setHasSearched] = useState<boolean>(false);

  const fetchPatientInfo = useCallback(
    async (noToFetch: string, isRefresh = false) => {
      const trimmedNo = noToFetch.trim();
      if (!trimmedNo) {
        Alert.alert('Validation Error', 'Please enter a valid Patient Number');
        return;
      }

      if (isRefresh) {
        setRefreshing(true);
      } else {
        setLoading(true);
      }
      setHasSearched(true);

      try {
        const data: PatientInformation = await getPatientInfo(trimmedNo);
        setPatientInfo(data);
      } catch (err: any) {
        setPatientInfo(null);
        Alert.alert(
          'Not Found / Error',
          err?.message || `Could not find information for Patient #${trimmedNo}`
        );
      } finally {
        setLoading(false);
        setRefreshing(false);
      }
    },
    []
  );

  useEffect(() => {
    const initialNo = route?.params?.no ?? route?.params?.patientNo;
    if (initialNo) {
      const stringNo = String(initialNo);
      setPatientNo(stringNo);
      fetchPatientInfo(stringNo);
    }
  }, [route?.params, fetchPatientInfo]);

  const handleSearch = () => {
    fetchPatientInfo(patientNo);
  };

  const onRefresh = () => {
    if (patientNo) {
      fetchPatientInfo(patientNo, true);
    } else {
      setRefreshing(false);
    }
  };

  return (
    <ScrollView
      style={styles.container}
      contentContainerStyle={styles.contentContainer}
      refreshControl={
        <RefreshControl refreshing={refreshing} onRefresh={onRefresh} colors={['#2B6CB0']} />
      }
    >
      <Text style={styles.headerTitle}>Patient Information</Text>

      {/* Search Bar Card */}
      <View style={styles.searchCard}>
        <Text style={styles.searchLabel}>Enter Patient Number (No):</Text>
        <View style={styles.searchRow}>
          <TextInput
            placeholder="e.g. 1"
            placeholderTextColor="#888"
            value={patientNo}
            onChangeText={setPatientNo}
            keyboardType="numeric"
            style={styles.searchInput}
            returnKeyType="search"
            onSubmitEditing={handleSearch}
          />
          <TouchableOpacity
            style={[styles.searchButton, loading && styles.buttonDisabled]}
            onPress={handleSearch}
            disabled={loading}
          >
            <Text style={styles.searchButtonText}>Search</Text>
          </TouchableOpacity>
        </View>
      </View>

      {/* Loading Indicator */}
      {loading && (
        <View style={styles.loadingContainer}>
          <ActivityIndicator size="large" color="#2B6CB0" />
          <Text style={styles.loadingText}>Fetching patient records...</Text>
        </View>
      )}

      {/* Patient Information Content */}
      {!loading && patientInfo && (
        <View style={styles.infoWrapper}>
          {/* General Details Card */}
          <View style={styles.card}>
            <View style={styles.cardHeader}>
              <Text style={styles.cardTitle}>Personal Details</Text>
              {patientInfo.sex ? (
                <View style={styles.badge}>
                  <Text style={styles.badgeText}>{patientInfo.sex}</Text>
                </View>
              ) : null}
            </View>

            <View style={styles.row}>
              <Text style={styles.label}>Name:</Text>
              <Text style={[styles.value, styles.nameHighlight]}>{patientInfo.name || 'N/A'}</Text>
            </View>

            <View style={styles.row}>
              <Text style={styles.label}>Birthday:</Text>
              <Text style={styles.value}>{patientInfo.birthday || 'N/A'}</Text>
            </View>

            <View style={styles.row}>
              <Text style={styles.label}>Occupation:</Text>
              <Text style={styles.value}>{patientInfo.occupation || 'N/A'}</Text>
            </View>

            <View style={styles.row}>
              <Text style={styles.label}>Allergies:</Text>
              <Text
                style={[
                  styles.value,
                  patientInfo.allergies ? styles.allergiesText : null,
                ]}
              >
                {patientInfo.allergies || 'None reported'}
              </Text>
            </View>
          </View>

          {/* Examinations List */}
          <View style={styles.sectionContainer}>
            <View style={styles.sectionHeaderRow}>
              <Text style={styles.sectionTitle}>Examinations</Text>
              <View style={styles.countBadge}>
                <Text style={styles.countBadgeText}>
                  {patientInfo.examination?.length ?? 0}
                </Text>
              </View>
            </View>

            {patientInfo.examination && patientInfo.examination.length > 0 ? (
              patientInfo.examination.map((exam, index) => (
                <View key={exam.examId ? `exam-${exam.examId}` : `exam-idx-${index}`} style={styles.subCard}>
                  <View style={styles.subCardHeader}>
                    <Text style={styles.subCardTitle}>
                      Examination #{exam.examId ?? index + 1}
                    </Text>
                    <Text style={styles.dateText}>{exam.exam_date || 'Date N/A'}</Text>
                  </View>

                  <View style={styles.grid}>
                    <View style={styles.gridItem}>
                      <Text style={styles.gridLabel}>Blood Pressure (BP)</Text>
                      <Text style={styles.gridValue}>{exam.bp ?? 'N/A'}</Text>
                    </View>
                    <View style={styles.gridItem}>
                      <Text style={styles.gridLabel}>Heart Pressure (HP)</Text>
                      <Text style={styles.gridValue}>{exam.hp ?? 'N/A'}</Text>
                    </View>
                    <View style={styles.gridItem}>
                      <Text style={styles.gridLabel}>Weight (WI)</Text>
                      <Text style={styles.gridValue}>{exam.wi != null ? `${exam.wi} kg` : 'N/A'}</Text>
                    </View>
                    <View style={styles.gridItem}>
                      <Text style={styles.gridLabel}>Temperature</Text>
                      <Text style={styles.gridValue}>{exam.temp != null ? `${exam.temp} °C` : 'N/A'}</Text>
                    </View>
                  </View>
                </View>
              ))
            ) : (
              <View style={styles.emptyCard}>
                <Text style={styles.emptyText}>No examination records found for this patient.</Text>
              </View>
            )}
          </View>

          {/* Treatments List */}
          <View style={styles.sectionContainer}>
            <View style={styles.sectionHeaderRow}>
              <Text style={styles.sectionTitle}>Treatments</Text>
              <View style={styles.countBadge}>
                <Text style={styles.countBadgeText}>
                  {patientInfo.treatment?.length ?? 0}
                </Text>
              </View>
            </View>

            {patientInfo.treatment && patientInfo.treatment.length > 0 ? (
              patientInfo.treatment.map((treat, index) => (
                <View key={treat.treatId ? `treat-${treat.treatId}` : `treat-idx-${index}`} style={styles.subCard}>
                  <View style={styles.subCardHeader}>
                    <Text style={styles.subCardTitle}>
                      Treatment #{treat.treatId ?? index + 1}
                    </Text>
                    <Text style={styles.dateText}>{treat.treat_date || 'Date N/A'}</Text>
                  </View>
                  <View style={styles.detailsContainer}>
                    <Text style={styles.detailsLabel}>Details / Prescription:</Text>
                    <Text style={styles.detailsText}>
                      {treat.treat_details || 'No details specified.'}
                    </Text>
                  </View>
                </View>
              ))
            ) : (
              <View style={styles.emptyCard}>
                <Text style={styles.emptyText}>No treatment records found for this patient.</Text>
              </View>
            )}
          </View>
        </View>
      )}

      {/* Initial / Empty State */}
      {!loading && !patientInfo && hasSearched && (
        <View style={styles.placeholderContainer}>
          <Text style={styles.placeholderTitle}>No Patient Found</Text>
          <Text style={styles.placeholderSubtitle}>
            Please verify the Patient Number and try searching again.
          </Text>
        </View>
      )}

      {!loading && !patientInfo && !hasSearched && (
        <View style={styles.placeholderContainer}>
          <Text style={styles.placeholderTitle}>Search Patient Record</Text>
          <Text style={styles.placeholderSubtitle}>
            Enter a Patient Number above to view medical history, examinations, and treatments.
          </Text>
        </View>
      )}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#F7FAFC',
  },
  contentContainer: {
    padding: 16,
    paddingBottom: 40,
  },
  headerTitle: {
    fontSize: 24,
    fontWeight: '700',
    color: '#2D3748',
    marginBottom: 16,
    textAlign: 'center',
  },
  searchCard: {
    backgroundColor: '#FFFFFF',
    padding: 16,
    borderRadius: 10,
    borderWidth: 1,
    borderColor: '#E2E8F0',
    marginBottom: 16,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 2,
  },
  searchLabel: {
    fontSize: 14,
    fontWeight: '600',
    color: '#4A5568',
    marginBottom: 8,
  },
  searchRow: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  searchInput: {
    flex: 1,
    height: 46,
    borderWidth: 1,
    borderColor: '#CBD5E0',
    borderRadius: 8,
    paddingHorizontal: 12,
    fontSize: 16,
    backgroundColor: '#F8FAFC',
    color: '#2D3748',
    marginRight: 10,
  },
  searchButton: {
    backgroundColor: '#2B6CB0',
    paddingVertical: 12,
    paddingHorizontal: 20,
    borderRadius: 8,
    justifyContent: 'center',
    alignItems: 'center',
  },
  buttonDisabled: {
    opacity: 0.6,
  },
  searchButtonText: {
    color: '#FFFFFF',
    fontSize: 15,
    fontWeight: '600',
  },
  loadingContainer: {
    paddingVertical: 30,
    alignItems: 'center',
  },
  loadingText: {
    marginTop: 10,
    fontSize: 15,
    color: '#718096',
  },
  infoWrapper: {
    marginTop: 4,
  },
  card: {
    backgroundColor: '#FFFFFF',
    borderRadius: 10,
    padding: 16,
    marginBottom: 16,
    borderWidth: 1,
    borderColor: '#E2E8F0',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 2,
  },
  cardHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: 12,
    borderBottomWidth: 1,
    borderBottomColor: '#EDF2F7',
    paddingBottom: 8,
  },
  cardTitle: {
    fontSize: 18,
    fontWeight: '700',
    color: '#2D3748',
  },
  badge: {
    backgroundColor: '#EBF8FF',
    paddingHorizontal: 10,
    paddingVertical: 4,
    borderRadius: 12,
    borderWidth: 1,
    borderColor: '#BEE3F8',
  },
  badgeText: {
    color: '#2B6CB0',
    fontSize: 12,
    fontWeight: '600',
  },
  row: {
    flexDirection: 'row',
    paddingVertical: 6,
    alignItems: 'center',
  },
  label: {
    width: 100,
    fontSize: 14,
    fontWeight: '600',
    color: '#718096',
  },
  value: {
    flex: 1,
    fontSize: 15,
    color: '#2D3748',
  },
  nameHighlight: {
    fontWeight: '700',
    color: '#1A202C',
    fontSize: 16,
  },
  allergiesText: {
    color: '#C53030',
    fontWeight: '600',
  },
  sectionContainer: {
    marginBottom: 16,
  },
  sectionHeaderRow: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 10,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: '700',
    color: '#2D3748',
    marginRight: 8,
  },
  countBadge: {
    backgroundColor: '#EDF2F7',
    paddingHorizontal: 8,
    paddingVertical: 2,
    borderRadius: 10,
  },
  countBadgeText: {
    fontSize: 12,
    fontWeight: '700',
    color: '#4A5568',
  },
  subCard: {
    backgroundColor: '#FFFFFF',
    borderRadius: 8,
    padding: 14,
    marginBottom: 10,
    borderWidth: 1,
    borderColor: '#E2E8F0',
  },
  subCardHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: 8,
    borderBottomWidth: 1,
    borderBottomColor: '#F7FAFC',
    paddingBottom: 6,
  },
  subCardTitle: {
    fontSize: 15,
    fontWeight: '600',
    color: '#2B6CB0',
  },
  dateText: {
    fontSize: 13,
    color: '#A0AEC0',
    fontWeight: '500',
  },
  grid: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    marginTop: 4,
  },
  gridItem: {
    width: '50%',
    paddingVertical: 4,
  },
  gridLabel: {
    fontSize: 12,
    color: '#718096',
    marginBottom: 2,
  },
  gridValue: {
    fontSize: 14,
    fontWeight: '600',
    color: '#2D3748',
  },
  detailsContainer: {
    marginTop: 4,
  },
  detailsLabel: {
    fontSize: 12,
    color: '#718096',
    marginBottom: 2,
  },
  detailsText: {
    fontSize: 14,
    color: '#2D3748',
    lineHeight: 20,
  },
  emptyCard: {
    backgroundColor: '#FFFFFF',
    borderRadius: 8,
    padding: 16,
    alignItems: 'center',
    borderWidth: 1,
    borderColor: '#E2E8F0',
  },
  emptyText: {
    color: '#A0AEC0',
    fontSize: 14,
    fontStyle: 'italic',
  },
  placeholderContainer: {
    marginTop: 40,
    alignItems: 'center',
    paddingHorizontal: 24,
  },
  placeholderTitle: {
    fontSize: 17,
    fontWeight: '600',
    color: '#718096',
  },
  placeholderSubtitle: {
    fontSize: 14,
    color: '#A0AEC0',
    textAlign: 'center',
    lineHeight: 20,
    marginTop: 6,
  },
});
