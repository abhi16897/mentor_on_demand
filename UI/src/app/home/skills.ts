import { MentorDetails } from '../authentication/MentorDetails';
import { Technology } from './Technology';

export interface skills{
    id: number,
    rating: number,
    experience: number,
    facilities: String,
    trainings: number,
    mentorDetails:MentorDetails,
    technologies:Technology,
}