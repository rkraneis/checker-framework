import org.checkerframework.checker.nullness.qual.*;

public class AnnotatedGenerics2 {
  // Top-level class to ensure that both classes are processed.

  class AnnotatedGenerics2Nble<T extends @Nullable Object> {
    // :: error: (initialization.field.uninitialized)
    @NonNull T myFieldNN;
    @Nullable T myFieldNble;
    // :: error: (initialization.field.uninitialized)
    T myFieldT;

    /* TODO: This test case gets affected by flow inference.
      * Investigate what the desired behavior is later.
     void fields() {
         myFieldNN = myFieldNN;
         myFieldNble = myFieldNN;
         myFieldT = myFieldNN;

         // TODO:: error: (assignment.type.incompatible)
         myFieldNN = myFieldNble;
         myFieldNble = myFieldNble;
         // TODO:: error: (assignment.type.incompatible)
         myFieldT = myFieldNble;

         // TODO:: error: (assignment.type.incompatible)
         myFieldNN = myFieldT;
         myFieldNble = myFieldT;
         myFieldT = myFieldT;
     }
    */

    void fields1() {
      myFieldNN = myFieldNN;
      myFieldNble = myFieldNN;
      myFieldT = myFieldNN;
    }

    void fields2() {
      // :: error: (assignment.type.incompatible)
      myFieldNN = myFieldNble;
      myFieldNble = myFieldNble;
      // :: error: (assignment.type.incompatible)
      myFieldT = myFieldNble;
    }

    void fields3() {
      // :: error: (assignment.type.incompatible)
      myFieldNN = myFieldT;
      myFieldNble = myFieldT;
      myFieldT = myFieldT;
    }

    void params(@NonNull T myParamNN, @Nullable T myParamNble, T myParamT) {
      myFieldNN = myParamNN;
      myFieldNble = myParamNN;
      myFieldT = myParamNN;

      // :: error: (assignment.type.incompatible)
      myFieldNN = myParamNble;
      myFieldNble = myParamNble;
      // :: error: (assignment.type.incompatible)
      myFieldT = myParamNble;

      // :: error: (assignment.type.incompatible)
      myFieldNN = myParamT;
      myFieldNble = myParamT;
      myFieldT = myParamT;
    }
  }

  class AnnotatedGenerics2NN<T extends @NonNull Object> {
    // :: error: (initialization.field.uninitialized)
    @NonNull T myFieldNN;
    @Nullable T myFieldNble;
    // :: error: (initialization.field.uninitialized)
    T myFieldT;

    /* TODO: This test case gets affected by flow inference.
     * Investigate what the desired behavior is later.
    void fields() {
        myFieldNN = myFieldNN;
        myFieldNble = myFieldNN;
        myFieldT = myFieldNN;

        // TODO:: error: (assignment.type.incompatible)
        myFieldNN = myFieldNble;
        myFieldNble = myFieldNble;
        // TODO:: error: (assignment.type.incompatible)
        myFieldT = myFieldNble;

        // TODO:: error: (assignment.type.incompatible)
        myFieldNN = myFieldT;
        myFieldNble = myFieldT;
        myFieldT = myFieldT;
    }
    */

    void fields1() {
      myFieldNN = myFieldNN;
      myFieldNble = myFieldNN;
      myFieldT = myFieldNN;
    }

    void fields2() {
      // :: error: (assignment.type.incompatible)
      myFieldNN = myFieldNble;
      myFieldNble = myFieldNble;
      // :: error: (assignment.type.incompatible)
      myFieldT = myFieldNble;
    }

    void fields3() {
      myFieldNN = myFieldT;
      myFieldNble = myFieldT;
      myFieldT = myFieldT;
    }

    void params(@NonNull T myParamNN, @Nullable T myParamNble, T myParamT) {
      myFieldNN = myParamNN;
      myFieldNble = myParamNN;
      myFieldT = myParamNN;

      // :: error: (assignment.type.incompatible)
      myFieldNN = myParamNble;
      myFieldNble = myParamNble;
      // :: error: (assignment.type.incompatible)
      myFieldT = myParamNble;

      myFieldNN = myParamT;
      myFieldNble = myParamT;
      myFieldT = myParamT;
    }
  }
}
