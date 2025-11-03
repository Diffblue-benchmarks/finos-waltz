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
import org.finos.waltz.model.involvement.ImmutableInvolvement.Json;
import org.finos.waltz.model.involvement.ImmutableInvolvementViewItem.Builder;
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementViewItemDiffblueTest {
  /**
   * Test Builder {@link Builder#from(InvolvementViewItem)}.
   * <ul>
   *   <li>Given {@link Person}.</li>
   *   <li>Then builder build involvement is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementViewItem); given Person; then builder build involvement is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementViewItem)"})
  void testBuilderFrom_givenPerson_thenBuilderBuildInvolvementIsJson() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();
    InvolvementViewItem instance = mock(InvolvementViewItem.class);
    when(instance.person()).thenReturn(mock(Person.class));
    Json json = new Json();
    when(instance.involvement()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvement();
    verify(instance).person();
    assertSame(json, builderResult.build().involvement());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementViewItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementViewItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementViewItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();
    InvolvementViewItem instance = mock(InvolvementViewItem.class);
    when(instance.person()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvement()).thenReturn(new Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvement();
    verify(instance).person();
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
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvement(new Json()));
  }

  /**
   * Test Builder {@link Builder#person(Person)}.
   * <ul>
   *   <li>When {@link Person}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#person(Person)}
   */
  @Test
  @DisplayName("Test Builder person(Person); when Person; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.person(Person)"})
  void testBuilderPerson_whenPerson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.person(mock(Person.class)));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableInvolvementViewItem.Json}
   *   <li>{@link ImmutableInvolvementViewItem.Json#setInvolvement(Involvement)}
   *   <li>{@link ImmutableInvolvementViewItem.Json#setPerson(Person)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableInvolvementViewItem.Json.<init>()",
      "void ImmutableInvolvementViewItem.Json.setInvolvement(Involvement)",
      "void ImmutableInvolvementViewItem.Json.setPerson(Person)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableInvolvementViewItem.Json actualJson = new ImmutableInvolvementViewItem.Json();
    actualJson.setInvolvement(new Json());
    actualJson.setPerson(null);

    // Assert
    Involvement involvement = actualJson.involvement;
    assertTrue(involvement instanceof Json);
    assertNull(((Json) involvement).employeeId);
    assertNull(((Json) involvement).provenance);
    assertNull(((Json) involvement).entityReference);
    assertNull(actualJson.person);
    assertEquals(0L, ((Json) involvement).kindId);
    assertFalse(((Json) involvement).isReadOnly);
    assertFalse(((Json) involvement).isReadOnlyIsSet);
    assertFalse(((Json) involvement).kindIdIsSet);
  }

  /**
   * Test Json {@link ImmutableInvolvementViewItem.Json#involvement()}.
   * <p>
   * Method under test: {@link ImmutableInvolvementViewItem.Json#involvement()}
   */
  @Test
  @DisplayName("Test Json involvement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Involvement ImmutableInvolvementViewItem.Json.involvement()"})
  void testJsonInvolvement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementViewItem.Json()).involvement());
  }

  /**
   * Test Json {@link ImmutableInvolvementViewItem.Json#person()}.
   * <p>
   * Method under test: {@link ImmutableInvolvementViewItem.Json#person()}
   */
  @Test
  @DisplayName("Test Json person()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person ImmutableInvolvementViewItem.Json.person()"})
  void testJsonPerson() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementViewItem.Json()).person());
  }
}
