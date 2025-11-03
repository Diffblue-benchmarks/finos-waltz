package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.involvement.ImmutableApplicationInvolvement.Builder;
import org.finos.waltz.model.involvement.ImmutableInvolvement.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationInvolvementDiffblueTest {
  /**
   * Test Builder {@link Builder#application(Application)}.
   * <ul>
   *   <li>When {@link Application}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#application(Application)}
   */
  @Test
  @DisplayName("Test Builder application(Application); when Application; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.application(Application)"})
  void testBuilderApplication_whenApplication_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.application(mock(Application.class)));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationInvolvement)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>Then builder build involvement is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationInvolvement)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationInvolvement); given Json (default constructor); then builder build involvement is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationInvolvement)"})
  void testBuilderFrom_givenJson_thenBuilderBuildInvolvementIsJson() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();
    ApplicationInvolvement instance = mock(ApplicationInvolvement.class);
    Json json = new Json();
    when(instance.involvement()).thenReturn(json);
    when(instance.application()).thenReturn(mock(Application.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).application();
    verify(instance).involvement();
    assertSame(json, builderResult.build().involvement());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationInvolvement)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationInvolvement)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationInvolvement); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationInvolvement)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();
    ApplicationInvolvement instance = mock(ApplicationInvolvement.class);
    when(instance.involvement()).thenThrow(new IllegalStateException("instance"));
    when(instance.application()).thenReturn(mock(Application.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).application();
    verify(instance).involvement();
  }

  /**
   * Test Builder {@link Builder#involvement(Involvement)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvement(Involvement)}
   */
  @Test
  @DisplayName("Test Builder involvement(Involvement); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvement(Involvement)"})
  void testBuilderInvolvement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvement(new Json()));
  }

  /**
   * Test Json {@link ImmutableApplicationInvolvement.Json#application()}.
   * <p>
   * Method under test: {@link ImmutableApplicationInvolvement.Json#application()}
   */
  @Test
  @DisplayName("Test Json application()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Application ImmutableApplicationInvolvement.Json.application()"})
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationInvolvement.Json()).application());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableApplicationInvolvement.Json}
   *   <li>{@link ImmutableApplicationInvolvement.Json#setApplication(Application)}
   *   <li>{@link ImmutableApplicationInvolvement.Json#setInvolvement(Involvement)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableApplicationInvolvement.Json.<init>()",
      "void ImmutableApplicationInvolvement.Json.setApplication(Application)",
      "void ImmutableApplicationInvolvement.Json.setInvolvement(Involvement)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableApplicationInvolvement.Json actualJson = new ImmutableApplicationInvolvement.Json();
    actualJson.setApplication(null);
    actualJson.setInvolvement(new Json());

    // Assert
    Involvement involvement = actualJson.involvement;
    assertTrue(involvement instanceof Json);
    assertNull(((Json) involvement).employeeId);
    assertNull(((Json) involvement).provenance);
    assertNull(((Json) involvement).entityReference);
    assertNull(actualJson.application);
    assertEquals(0L, ((Json) involvement).kindId);
    assertFalse(((Json) involvement).isReadOnly);
    assertFalse(((Json) involvement).isReadOnlyIsSet);
    assertFalse(((Json) involvement).kindIdIsSet);
  }

  /**
   * Test Json {@link ImmutableApplicationInvolvement.Json#involvement()}.
   * <p>
   * Method under test: {@link ImmutableApplicationInvolvement.Json#involvement()}
   */
  @Test
  @DisplayName("Test Json involvement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Involvement ImmutableApplicationInvolvement.Json.involvement()"})
  void testJsonInvolvement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationInvolvement.Json()).involvement());
  }
}
