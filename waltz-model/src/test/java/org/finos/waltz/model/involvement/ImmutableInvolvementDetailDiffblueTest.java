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
import org.finos.waltz.model.involvement.ImmutableInvolvementDetail.Builder;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#from(InvolvementDetail)}.
   * <p>
   * Method under test: {@link Builder#from(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementDetail)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementDetail)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetail.builder();
    InvolvementDetail instance = mock(InvolvementDetail.class);
    when(instance.person()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvement()).thenReturn(new Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvement();
    verify(instance).person();
  }

  /**
   * Test Builder {@link Builder#from(InvolvementDetail)}.
   * <p>
   * Method under test: {@link Builder#from(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementDetail)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementDetail)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetail.builder();
    InvolvementDetail instance = mock(InvolvementDetail.class);
    when(instance.involvementKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.person()).thenReturn(mock(Person.class));
    when(instance.involvement()).thenReturn(new Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvement();
    verify(instance).involvementKind();
    verify(instance).person();
  }

  /**
   * Test Builder {@link Builder#from(InvolvementDetail)}.
   * <ul>
   *   <li>Given {@link InvolvementKind}.</li>
   *   <li>Then builder build involvement is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementDetail); given InvolvementKind; then builder build involvement is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementDetail)"})
  void testBuilderFrom_givenInvolvementKind_thenBuilderBuildInvolvementIsJson() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetail.builder();
    InvolvementDetail instance = mock(InvolvementDetail.class);
    when(instance.involvementKind()).thenReturn(mock(InvolvementKind.class));
    when(instance.person()).thenReturn(mock(Person.class));
    Json json = new Json();
    when(instance.involvement()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvement();
    verify(instance).involvementKind();
    verify(instance).person();
    assertSame(json, builderResult.build().involvement());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#involvementKind(InvolvementKind)}.
   * <ul>
   *   <li>When {@link InvolvementKind}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementKind(InvolvementKind)}
   */
  @Test
  @DisplayName("Test Builder involvementKind(InvolvementKind); when InvolvementKind; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementKind(InvolvementKind)"})
  void testBuilderInvolvementKind_whenInvolvementKind_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKind(mock(InvolvementKind.class)));
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
    Builder builderResult = ImmutableInvolvementDetail.builder();

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
    Builder builderResult = ImmutableInvolvementDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.person(mock(Person.class)));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableInvolvementDetail.Json}
   *   <li>{@link ImmutableInvolvementDetail.Json#setInvolvement(Involvement)}
   *   <li>{@link ImmutableInvolvementDetail.Json#setInvolvementKind(InvolvementKind)}
   *   <li>{@link ImmutableInvolvementDetail.Json#setPerson(Person)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableInvolvementDetail.Json.<init>()",
      "void ImmutableInvolvementDetail.Json.setInvolvement(Involvement)",
      "void ImmutableInvolvementDetail.Json.setInvolvementKind(InvolvementKind)",
      "void ImmutableInvolvementDetail.Json.setPerson(Person)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableInvolvementDetail.Json actualJson = new ImmutableInvolvementDetail.Json();
    actualJson.setInvolvement(new Json());
    actualJson.setInvolvementKind(null);
    actualJson.setPerson(null);

    // Assert
    Involvement involvement = actualJson.involvement;
    assertTrue(involvement instanceof Json);
    assertNull(((Json) involvement).employeeId);
    assertNull(((Json) involvement).provenance);
    assertNull(((Json) involvement).entityReference);
    assertNull(actualJson.involvementKind);
    assertNull(actualJson.person);
    assertEquals(0L, ((Json) involvement).kindId);
    assertFalse(((Json) involvement).isReadOnly);
    assertFalse(((Json) involvement).isReadOnlyIsSet);
    assertFalse(((Json) involvement).kindIdIsSet);
  }

  /**
   * Test Json {@link ImmutableInvolvementDetail.Json#involvement()}.
   * <p>
   * Method under test: {@link ImmutableInvolvementDetail.Json#involvement()}
   */
  @Test
  @DisplayName("Test Json involvement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Involvement ImmutableInvolvementDetail.Json.involvement()"})
  void testJsonInvolvement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementDetail.Json()).involvement());
  }

  /**
   * Test Json {@link ImmutableInvolvementDetail.Json#involvementKind()}.
   * <p>
   * Method under test: {@link ImmutableInvolvementDetail.Json#involvementKind()}
   */
  @Test
  @DisplayName("Test Json involvementKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InvolvementKind ImmutableInvolvementDetail.Json.involvementKind()"})
  void testJsonInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementDetail.Json()).involvementKind());
  }

  /**
   * Test Json {@link ImmutableInvolvementDetail.Json#person()}.
   * <p>
   * Method under test: {@link ImmutableInvolvementDetail.Json#person()}
   */
  @Test
  @DisplayName("Test Json person()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person ImmutableInvolvementDetail.Json.person()"})
  void testJsonPerson() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementDetail.Json()).person());
  }
}
