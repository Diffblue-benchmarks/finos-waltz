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
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementViewItemDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableInvolvementViewItem.Builder#from(InvolvementViewItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementViewItem.Builder builderResult = ImmutableInvolvementViewItem.builder();
    InvolvementViewItem instance = mock(InvolvementViewItem.class);
    when(instance.person()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvement()).thenReturn(new ImmutableInvolvement.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvement();
    verify(instance).person();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementViewItem.Builder#from(InvolvementViewItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementViewItem.Builder builderResult = ImmutableInvolvementViewItem.builder();
    InvolvementViewItem instance = mock(InvolvementViewItem.class);
    when(instance.person()).thenReturn(mock(Person.class));
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();
    when(instance.involvement()).thenReturn(json);

    // Act
    ImmutableInvolvementViewItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvement();
    verify(instance).person();
    assertSame(json, builderResult.build().involvement());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementViewItem.Builder#involvement(Involvement)}
   */
  @Test
  void testBuilderInvolvement() {
    // Arrange
    ImmutableInvolvementViewItem.Builder builderResult = ImmutableInvolvementViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvement(new ImmutableInvolvement.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementViewItem.Builder#involvement(Involvement)}
   */
  @Test
  void testBuilderInvolvement2() {
    // Arrange
    ImmutableInvolvementViewItem.Builder builderResult = ImmutableInvolvementViewItem.builder();

    ImmutableInvolvement.Json involvement = new ImmutableInvolvement.Json();
    involvement.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.involvement(involvement));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementViewItem.Builder#person(Person)}
   */
  @Test
  void testBuilderPerson() {
    // Arrange
    ImmutableInvolvementViewItem.Builder builderResult = ImmutableInvolvementViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.person(mock(Person.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementViewItem#copyOf(InvolvementViewItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementViewItem instance = mock(InvolvementViewItem.class);
    when(instance.person()).thenReturn(mock(Person.class));
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();
    when(instance.involvement()).thenReturn(json);

    // Act
    ImmutableInvolvementViewItem actualCopyOfResult = ImmutableInvolvementViewItem.copyOf(instance);

    // Assert
    verify(instance).involvement();
    verify(instance).person();
    assertSame(json, actualCopyOfResult.involvement());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementViewItem#fromJson(ImmutableInvolvementViewItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableInvolvementViewItem.Json json = new ImmutableInvolvementViewItem.Json();
    ImmutableInvolvement.Json involvement = new ImmutableInvolvement.Json();
    json.setInvolvement(involvement);
    json.setPerson(mock(Person.class));

    // Act
    ImmutableInvolvementViewItem actualFromJsonResult = ImmutableInvolvementViewItem.fromJson(json);

    // Assert
    assertSame(involvement, actualFromJsonResult.involvement());
    Person expectedPersonResult = json.person;
    assertSame(expectedPersonResult, actualFromJsonResult.person());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableInvolvementViewItem.Json}
   *   <li>{@link ImmutableInvolvementViewItem.Json#setInvolvement(Involvement)}
   *   <li>{@link ImmutableInvolvementViewItem.Json#setPerson(Person)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableInvolvementViewItem.Json actualJson = new ImmutableInvolvementViewItem.Json();
    actualJson.setInvolvement(new ImmutableInvolvement.Json());
    actualJson.setPerson(null);

    // Assert
    Involvement involvement = actualJson.involvement;
    assertTrue(involvement instanceof ImmutableInvolvement.Json);
    assertNull(((ImmutableInvolvement.Json) involvement).employeeId);
    assertNull(((ImmutableInvolvement.Json) involvement).provenance);
    assertNull(((ImmutableInvolvement.Json) involvement).entityReference);
    assertNull(actualJson.person);
    assertEquals(0L, ((ImmutableInvolvement.Json) involvement).kindId);
    assertFalse(((ImmutableInvolvement.Json) involvement).isReadOnly);
    assertFalse(((ImmutableInvolvement.Json) involvement).isReadOnlyIsSet);
    assertFalse(((ImmutableInvolvement.Json) involvement).kindIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableInvolvementViewItem.Json#involvement()}
   */
  @Test
  void testJsonInvolvement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementViewItem.Json()).involvement());
  }

  /**
   * Method under test: {@link ImmutableInvolvementViewItem.Json#person()}
   */
  @Test
  void testJsonPerson() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementViewItem.Json()).person());
  }
}
