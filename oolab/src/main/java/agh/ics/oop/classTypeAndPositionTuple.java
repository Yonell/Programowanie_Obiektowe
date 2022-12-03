package agh.ics.oop;

import java.util.Comparator;

/* I had to make this record, because there was a bug causing MabBoundary not to delete an object from a TreeList.
The comparator I used to automate sorting had either no information about oldPosition or newPosition.
That flaw caused a situation in which there was no guarantee it would find an object to remove. */

public record classTypeAndPositionTuple(Vector2d position, Class<?> classType) {

    static final Comparator<classTypeAndPositionTuple> compareToByX = new Comparator<>() {
        @Override
        public int compare(classTypeAndPositionTuple o1, classTypeAndPositionTuple o2) {
            if (o1.position().x() != o2.position().x()) {
                return Integer.compare(o1.position.x(), o2.position.x());
            }
            if (o1.position().y() != o2.position().y()) {
                return Integer.compare(o1.position.y(), o2.position.y());
            }
            if (o1.classType() != o2.classType()) {
                return (o1.classType() == Animal.class) ? 1 : -1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };

    static Comparator<classTypeAndPositionTuple> compareToByY = new Comparator<>() {
        @Override
        public int compare(classTypeAndPositionTuple o1, classTypeAndPositionTuple o2) {
            if (o1.position().y() != o2.position().y()) {
                return Integer.compare(o1.position.y(), o2.position.y());
            }
            if (o1.position().x() != o2.position().x()) {
                return Integer.compare(o1.position.x(), o2.position.x());
            }
            if (o1.classType() != o2.classType()) {
                return (o1.classType() == Animal.class) ? 1 : -1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };
}
