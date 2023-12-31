export class Trainer {
  trainerId!: number;
  trainerName!: string;
  trainerExperience!: number;
  description!: {
    descriptionId: number;
    descriptionName?:string;
  };
  city!: {
    cityId: number;
    cityName?:string;
  };
  state!: {
    stateId: number;
    stateName?:string;
  };
  country!: {
    countryId: number;
    countryName?:string;
  };
  trainerNumber!: string;
}







