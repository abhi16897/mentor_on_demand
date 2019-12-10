import { StudentDetails } from '../authentication/StudentDetails';
import { MentorDetails } from '../authentication/MentorDetails';
import { MentorSkills } from '../authentication/MentorSkills';

export interface Training {
    id:number,
    status:String,
    progress:String,
    rating:number,
    amount:number,
    studentDetails: StudentDetails,
    mentorDetails: MentorDetails,
    mentorSkills: MentorSkills,
}
