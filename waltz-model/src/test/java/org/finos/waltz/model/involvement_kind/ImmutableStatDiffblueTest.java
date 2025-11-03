package org.finos.waltz.model.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.involvement_kind.ImmutableStat.Builder;
import org.finos.waltz.model.involvement_kind.ImmutableStat.Json;
import org.finos.waltz.model.involvement_kind.InvolvementKindUsageStat.Stat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableStatDiffblueTest {
  /**
   * Test Builder {@link Builder#entityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#entityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder entityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityKind(EntityKind)"})
  void testBuilderEntityKind() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#from(Stat)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build personCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Stat)}
   */
  @Test
  @DisplayName("Test Builder from(Stat); given 'true'; then builder build personCount is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Stat)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildPersonCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();
    Stat instance = mock(Stat.class);
    when(instance.isCountOfRemovedPeople()).thenReturn(true);
    when(instance.personCount()).thenReturn(3);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityKind();
    verify(instance).isCountOfRemovedPeople();
    verify(instance).personCount();
    ImmutableStat buildResult = builderResult.build();
    assertEquals(3, buildResult.personCount());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertTrue(buildResult.isCountOfRemovedPeople());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Stat)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Stat)}
   */
  @Test
  @DisplayName("Test Builder from(Stat); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Stat)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();
    Stat instance = mock(Stat.class);
    when(instance.isCountOfRemovedPeople()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityKind();
    verify(instance).isCountOfRemovedPeople();
  }

  /**
   * Test Builder {@link Builder#isCountOfRemovedPeople(boolean)}.
   * <p>
   * Method under test: {@link Builder#isCountOfRemovedPeople(boolean)}
   */
  @Test
  @DisplayName("Test Builder isCountOfRemovedPeople(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isCountOfRemovedPeople(boolean)"})
  void testBuilderIsCountOfRemovedPeople() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isCountOfRemovedPeople(true));
  }

  /**
   * Test Builder {@link Builder#personCount(int)}.
   * <p>
   * Method under test: {@link Builder#personCount(int)}
   */
  @Test
  @DisplayName("Test Builder personCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.personCount(int)"})
  void testBuilderPersonCount() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personCount(3));
  }

  /**
   * Test Json {@link Json#entityKind()}.
   * <p>
   * Method under test: {@link Json#entityKind()}
   */
  @Test
  @DisplayName("Test Json entityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.entityKind()"})
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityKind());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEntityKind(EntityKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityKind(EntityKind.ALL);

    // Assert
    assertEquals(0, actualJson.personCount);
    assertEquals(EntityKind.ALL, actualJson.entityKind);
    assertFalse(actualJson.isCountOfRemovedPeople);
    assertFalse(actualJson.isCountOfRemovedPeopleIsSet);
    assertFalse(actualJson.personCountIsSet);
  }

  /**
   * Test Json {@link Json#isCountOfRemovedPeople()}.
   * <p>
   * Method under test: {@link Json#isCountOfRemovedPeople()}
   */
  @Test
  @DisplayName("Test Json isCountOfRemovedPeople()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isCountOfRemovedPeople()"})
  void testJsonIsCountOfRemovedPeople() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isCountOfRemovedPeople());
  }

  /**
   * Test Json {@link Json#personCount()}.
   * <p>
   * Method under test: {@link Json#personCount()}
   */
  @Test
  @DisplayName("Test Json personCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.personCount()"})
  void testJsonPersonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).personCount());
  }

  /**
   * Test Json {@link Json#setIsCountOfRemovedPeople(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsCountOfRemovedPeople(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsCountOfRemovedPeople(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsCountOfRemovedPeople(boolean)"})
  void testJsonSetIsCountOfRemovedPeople() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsCountOfRemovedPeople(true);

    // Assert
    assertTrue(json.isCountOfRemovedPeople);
    assertTrue(json.isCountOfRemovedPeopleIsSet);
  }

  /**
   * Test Json {@link Json#setPersonCount(int)}.
   * <p>
   * Method under test: {@link Json#setPersonCount(int)}
   */
  @Test
  @DisplayName("Test Json setPersonCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPersonCount(int)"})
  void testJsonSetPersonCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPersonCount(3);

    // Assert
    assertEquals(3, json.personCount);
    assertTrue(json.personCountIsSet);
  }
}
