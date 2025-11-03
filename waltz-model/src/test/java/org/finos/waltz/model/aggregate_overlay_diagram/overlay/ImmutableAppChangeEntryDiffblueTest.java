package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.ChangeDirection;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAppChangeEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAppChangeEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppChangeEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#appRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#appRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder appRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appRef(EntityReference)"})
  void testBuilderAppRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#changeDirection(ChangeDirection)}.
   * <p>
   * Method under test: {@link Builder#changeDirection(ChangeDirection)}
   */
  @Test
  @DisplayName("Test Builder changeDirection(ChangeDirection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeDirection(ChangeDirection)"})
  void testBuilderChangeDirection() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeDirection(ChangeDirection.INBOUND));
  }

  /**
   * Test Builder {@link Builder#date(LocalDate)}.
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#date(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder date(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.date(LocalDate)"})
  void testBuilderDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.date(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#from(AppChangeEntry)}.
   * <p>
   * Method under test: {@link Builder#from(AppChangeEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppChangeEntry)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    AppChangeEntry instance = mock(AppChangeEntry.class);
    when(instance.changeDirection()).thenThrow(new IllegalStateException("instance"));
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appRef();
    verify(instance).changeDirection();
  }

  /**
   * Test Builder {@link Builder#from(AppChangeEntry)}.
   * <ul>
   *   <li>Then builder build changeDirection is {@code INBOUND}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppChangeEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeEntry); then builder build changeDirection is 'INBOUND'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppChangeEntry)"})
  void testBuilderFrom_thenBuilderBuildChangeDirectionIsInbound() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    AppChangeEntry instance = mock(AppChangeEntry.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.date()).thenReturn(ofResult);
    when(instance.changeDirection()).thenReturn(ChangeDirection.INBOUND);
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appRef();
    verify(instance).changeDirection();
    verify(instance).date();
    ImmutableAppChangeEntry buildResult = builderResult.build();
    assertEquals(ChangeDirection.INBOUND, buildResult.changeDirection());
    assertSame(ofResult, buildResult.date());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppChangeEntry)}.
   * <ul>
   *   <li>When {@link AppChangeEntry} {@link AppChangeEntry#date()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppChangeEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeEntry); when AppChangeEntry date() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppChangeEntry)"})
  void testBuilderFrom_whenAppChangeEntryDateThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableAppChangeEntry.builder();
    AppChangeEntry instance = mock(AppChangeEntry.class);
    when(instance.date()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeDirection()).thenReturn(ChangeDirection.INBOUND);
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appRef();
    verify(instance).changeDirection();
    verify(instance).date();
  }

  /**
   * Test Json {@link Json#appRef()}.
   * <p>
   * Method under test: {@link Json#appRef()}
   */
  @Test
  @DisplayName("Test Json appRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.appRef()"})
  void testJsonAppRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appRef());
  }

  /**
   * Test Json {@link Json#changeDirection()}.
   * <p>
   * Method under test: {@link Json#changeDirection()}
   */
  @Test
  @DisplayName("Test Json changeDirection()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChangeDirection Json.changeDirection()"})
  void testJsonChangeDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeDirection());
  }

  /**
   * Test Json {@link Json#date()}.
   * <p>
   * Method under test: {@link Json#date()}
   */
  @Test
  @DisplayName("Test Json date()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.date()"})
  void testJsonDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).date());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAppRef(EntityReference)}
   *   <li>{@link Json#setChangeDirection(ChangeDirection)}
   *   <li>{@link Json#setDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAppRef(EntityReference)",
      "void Json.setChangeDirection(ChangeDirection)", "void Json.setDate(LocalDate)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAppRef(null);
    actualJson.setChangeDirection(ChangeDirection.INBOUND);
    actualJson.setDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", actualJson.date.toString());
  }
}
