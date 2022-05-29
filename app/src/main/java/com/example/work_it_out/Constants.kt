package com.example.work_it_out

object Constants {
    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.ic_jumping_jacks,
            false,
            false
        )
        exerciseList.add(jumpingJacks)

        val wallSit = ExerciseModel(
            2,
            "Wall Sit",
            R.drawable.ic_wall_sit,
            false,
            false
        )
        exerciseList.add(wallSit)

        val abdominalCrunches = ExerciseModel(
            3,
            "Abdominal Crunches",
            R.drawable.ic_abdominal_crunch,
            false,
            false
        )
        exerciseList.add(abdominalCrunches)

        val highKneesRunning = ExerciseModel(
            4,
            "High Knees Running",
            R.drawable.ic_high_knees_running_in_place,
            false,
            false
        )
        exerciseList.add(highKneesRunning)

        val lunges = ExerciseModel(
            5,
            "Lunges",
            R.drawable.ic_lunge,
            false,
            false
        )
        exerciseList.add(lunges)

        val plank = ExerciseModel(
            6,
            "Plank",
            R.drawable.ic_plank,
            false,
            false
        )
        exerciseList.add(plank)

        val pushUp = ExerciseModel(
            7,
            "Push Ups",
            R.drawable.ic_push_up,
            false,
            false
        )
        exerciseList.add(pushUp)

        val pushUpRotation = ExerciseModel(
            8,
            "Rotational PushUps",
            R.drawable.ic_push_up_and_rotation,
            false,
            false
        )
        exerciseList.add(pushUpRotation)

        val sidePlank = ExerciseModel(
            9,
            "Side Plank",
            R.drawable.ic_side_plank,
            false,
            false
        )
        exerciseList.add(sidePlank)

        val squat = ExerciseModel(
            10,
            "Squats",
            R.drawable.ic_squat,
            false,
            false
        )
        exerciseList.add(squat)


        val stepUpOntoChair = ExerciseModel(
            11,
            "Step Up On Chair",
            R.drawable.ic_step_up_onto_chair,
            false,
            false
        )
        exerciseList.add(stepUpOntoChair)

        val chairDips = ExerciseModel(
            12,
            "Chair Dips",
            R.drawable.ic_triceps_dip_on_chair,
            false,
            false
        )
        exerciseList.add(chairDips)

        return exerciseList
    }
}