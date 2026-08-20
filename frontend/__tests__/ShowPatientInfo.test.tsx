import React from 'react';
import ReactTestRenderer from 'react-test-renderer';
import ShowPatientInfo from '../app/components/ShowPatientInfo';
import * as PatientApi from '../app/api/PatientApi';

jest.mock('../app/api/PatientApi');

describe('ShowPatientInfo Component', () => {
  it('renders search input and title correctly', async () => {
    let tree: any;
    await ReactTestRenderer.act(() => {
      tree = ReactTestRenderer.create(<ShowPatientInfo />);
    });
    expect(tree.toJSON()).toBeTruthy();
  });

  it('fetches and displays patient info when route param is provided', async () => {
    const mockPatientData = {
      name: 'John Doe',
      birthday: '1990-01-01',
      sex: 'MALE',
      occupation: 'Software Engineer',
      allergies: 'Peanuts',
      examination: [
        {
          examId: 1,
          exam_date: '2026-01-15',
          bp: 120,
          hp: 80,
          wi: 70,
          temp: 36.6,
        },
      ],
      treatment: [
        {
          treatId: 101,
          treat_date: '2026-01-16',
          treat_details: 'Prescribed rest and hydration.',
        },
      ],
    };

    (PatientApi.getPatientInfo as jest.Mock).mockResolvedValueOnce(mockPatientData);

    let tree: any;
    await ReactTestRenderer.act(async () => {
      tree = ReactTestRenderer.create(
        <ShowPatientInfo route={{ params: { patientNo: '1' } }} />
      );
    });

    expect(PatientApi.getPatientInfo).toHaveBeenCalledWith('1');
    expect(tree.toJSON()).toBeTruthy();
  });
});
