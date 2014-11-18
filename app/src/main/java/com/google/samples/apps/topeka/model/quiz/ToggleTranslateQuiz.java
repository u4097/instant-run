/*
 * Copyright 2014 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.samples.apps.topeka.model.quiz;

import android.os.Parcel;

import java.util.Arrays;

public final class ToggleTranslateQuiz extends OptionsQuiz<String[]> {

    public ToggleTranslateQuiz(String question, int[] answer, String[][] options) {
        super(question, answer, options);
    }

    public ToggleTranslateQuiz(Parcel in) {
        super(in);
        setAnswer(in.createIntArray());
        setOptions((String[][]) in.readSerializable());
    }

    @Override
    public QuizType getType() {
        return QuizType.TOGGLE_TRANSLATE;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeIntArray(getAnswer());
        dest.writeSerializable(getOptions());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OptionsQuiz)) {
            return false;
        }

        ToggleTranslateQuiz that = (ToggleTranslateQuiz) o;

        if (!Arrays.equals(getAnswer(), ((int[]) that.getAnswer()))) {
            return false;
        }

        if (!Arrays.deepEquals(getOptions(), that.getOptions())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(getOptions());
        return result;
    }
}