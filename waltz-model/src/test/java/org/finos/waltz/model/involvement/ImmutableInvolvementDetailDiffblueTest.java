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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementDetailDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableInvolvementDetail.Builder#from(InvolvementDetail)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();
    InvolvementDetail instance = mock(InvolvementDetail.class);
    when(instance.person()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvement()).thenReturn(new ImmutableInvolvement.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvement();
    verify(instance).person();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetail.Builder#from(InvolvementDetail)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();
    InvolvementDetail instance = mock(InvolvementDetail.class);
    when(instance.involvementKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.person()).thenReturn(mock(Person.class));
    when(instance.involvement()).thenReturn(new ImmutableInvolvement.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvement();
    verify(instance).involvementKind();
    verify(instance).person();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetail.Builder#from(InvolvementDetail)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();
    InvolvementDetail instance = mock(InvolvementDetail.class);
    when(instance.involvementKind()).thenReturn(mock(InvolvementKind.class));
    when(instance.person()).thenReturn(mock(Person.class));
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();
    when(instance.involvement()).thenReturn(json);

    // Act
    ImmutableInvolvementDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvement();
    verify(instance).involvementKind();
    verify(instance).person();
    assertSame(json, builderResult.build().involvement());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetail.Builder#involvement(Involvement)}
   */
  @Test
  void testBuilderInvolvement() {
    // Arrange
    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvement(new ImmutableInvolvement.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetail.Builder#involvement(Involvement)}
   */
  @Test
  void testBuilderInvolvement2() {
    // Arrange
    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    ImmutableInvolvement.Json involvement = new ImmutableInvolvement.Json();
    involvement.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.involvement(involvement));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetail.Builder#involvementKind(InvolvementKind)}
   */
  @Test
  void testBuilderInvolvementKind() {
    // Arrange
    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKind(mock(InvolvementKind.class)));
  }

  /**
   * Method under test: {@link ImmutableInvolvementDetail.Builder#person(Person)}
   */
  @Test
  void testBuilderPerson() {
    // Arrange
    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.person(mock(Person.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetail#copyOf(InvolvementDetail)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementDetail instance = mock(InvolvementDetail.class);
    when(instance.involvementKind()).thenReturn(mock(InvolvementKind.class));
    when(instance.person()).thenReturn(mock(Person.class));
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();
    when(instance.involvement()).thenReturn(json);

    // Act
    ImmutableInvolvementDetail actualCopyOfResult = ImmutableInvolvementDetail.copyOf(instance);

    // Assert
    verify(instance).involvement();
    verify(instance).involvementKind();
    verify(instance).person();
    assertSame(json, actualCopyOfResult.involvement());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementDetail#fromJson(ImmutableInvolvementDetail.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableInvolvementDetail.Json json = new ImmutableInvolvementDetail.Json();
    json.setInvolvementKind(mock(InvolvementKind.class));
    ImmutableInvolvement.Json involvement = new ImmutableInvolvement.Json();
    json.setInvolvement(involvement);
    json.setPerson(mock(Person.class));

    // Act
    ImmutableInvolvementDetail actualFromJsonResult = ImmutableInvolvementDetail.fromJson(json);

    // Assert
    assertSame(involvement, actualFromJsonResult.involvement());
    InvolvementKind expectedInvolvementKindResult = json.involvementKind;
    assertSame(expectedInvolvementKindResult, actualFromJsonResult.involvementKind());
    Person expectedPersonResult = json.person;
    assertSame(expectedPersonResult, actualFromJsonResult.person());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableInvolvementDetail.Json}
   *   <li>{@link ImmutableInvolvementDetail.Json#setInvolvement(Involvement)}
   *   <li>
   * {@link ImmutableInvolvementDetail.Json#setInvolvementKind(InvolvementKind)}
   *   <li>{@link ImmutableInvolvementDetail.Json#setPerson(Person)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableInvolvementDetail.Json actualJson = new ImmutableInvolvementDetail.Json();
    actualJson.setInvolvement(new ImmutableInvolvement.Json());
    actualJson.setInvolvementKind(null);
    actualJson.setPerson(null);

    // Assert
    Involvement involvement = actualJson.involvement;
    assertTrue(involvement instanceof ImmutableInvolvement.Json);
    assertNull(((ImmutableInvolvement.Json) involvement).employeeId);
    assertNull(((ImmutableInvolvement.Json) involvement).provenance);
    assertNull(((ImmutableInvolvement.Json) involvement).entityReference);
    assertNull(actualJson.involvementKind);
    assertNull(actualJson.person);
    assertEquals(0L, ((ImmutableInvolvement.Json) involvement).kindId);
    assertFalse(((ImmutableInvolvement.Json) involvement).isReadOnly);
    assertFalse(((ImmutableInvolvement.Json) involvement).isReadOnlyIsSet);
    assertFalse(((ImmutableInvolvement.Json) involvement).kindIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableInvolvementDetail.Json#involvement()}
   */
  @Test
  void testJsonInvolvement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementDetail.Json()).involvement());
  }

  /**
   * Method under test: {@link ImmutableInvolvementDetail.Json#involvementKind()}
   */
  @Test
  void testJsonInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementDetail.Json()).involvementKind());
  }

  /**
   * Method under test: {@link ImmutableInvolvementDetail.Json#person()}
   */
  @Test
  void testJsonPerson() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementDetail.Json()).person());
  }
}
