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
import org.finos.waltz.model.application.Application;
import org.junit.jupiter.api.Test;

class ImmutableApplicationInvolvementDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationInvolvement.Builder#application(Application)}
   */
  @Test
  void testBuilderApplication() {
    // Arrange
    ImmutableApplicationInvolvement.Builder builderResult = ImmutableApplicationInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.application(mock(Application.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationInvolvement.Builder#from(ApplicationInvolvement)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationInvolvement.Builder builderResult = ImmutableApplicationInvolvement.builder();
    ApplicationInvolvement instance = mock(ApplicationInvolvement.class);
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();
    when(instance.involvement()).thenReturn(json);
    when(instance.application()).thenReturn(mock(Application.class));

    // Act
    ImmutableApplicationInvolvement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).application();
    verify(instance).involvement();
    assertSame(json, builderResult.build().involvement());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationInvolvement.Builder#from(ApplicationInvolvement)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationInvolvement.Builder builderResult = ImmutableApplicationInvolvement.builder();
    ApplicationInvolvement instance = mock(ApplicationInvolvement.class);
    when(instance.involvement()).thenThrow(new IllegalStateException("instance"));
    when(instance.application()).thenReturn(mock(Application.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).application();
    verify(instance).involvement();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationInvolvement.Builder#involvement(Involvement)}
   */
  @Test
  void testBuilderInvolvement() {
    // Arrange
    ImmutableApplicationInvolvement.Builder builderResult = ImmutableApplicationInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvement(new ImmutableInvolvement.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationInvolvement.Builder#involvement(Involvement)}
   */
  @Test
  void testBuilderInvolvement2() {
    // Arrange
    ImmutableApplicationInvolvement.Builder builderResult = ImmutableApplicationInvolvement.builder();

    ImmutableInvolvement.Json involvement = new ImmutableInvolvement.Json();
    involvement.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.involvement(involvement));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationInvolvement#copyOf(ApplicationInvolvement)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationInvolvement instance = mock(ApplicationInvolvement.class);
    ImmutableInvolvement.Json json = new ImmutableInvolvement.Json();
    when(instance.involvement()).thenReturn(json);
    when(instance.application()).thenReturn(mock(Application.class));

    // Act
    ImmutableApplicationInvolvement actualCopyOfResult = ImmutableApplicationInvolvement.copyOf(instance);

    // Assert
    verify(instance).application();
    verify(instance).involvement();
    assertSame(json, actualCopyOfResult.involvement());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationInvolvement#fromJson(ImmutableApplicationInvolvement.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationInvolvement.Json json = new ImmutableApplicationInvolvement.Json();
    json.setApplication(mock(Application.class));
    ImmutableInvolvement.Json involvement = new ImmutableInvolvement.Json();
    json.setInvolvement(involvement);

    // Act
    ImmutableApplicationInvolvement actualFromJsonResult = ImmutableApplicationInvolvement.fromJson(json);

    // Assert
    assertSame(involvement, actualFromJsonResult.involvement());
    Application expectedApplicationResult = json.application;
    assertSame(expectedApplicationResult, actualFromJsonResult.application());
  }

  /**
   * Method under test: {@link ImmutableApplicationInvolvement.Json#application()}
   */
  @Test
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationInvolvement.Json()).application());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableApplicationInvolvement.Json}
   *   <li>{@link ImmutableApplicationInvolvement.Json#setApplication(Application)}
   *   <li>{@link ImmutableApplicationInvolvement.Json#setInvolvement(Involvement)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableApplicationInvolvement.Json actualJson = new ImmutableApplicationInvolvement.Json();
    actualJson.setApplication(null);
    actualJson.setInvolvement(new ImmutableInvolvement.Json());

    // Assert
    Involvement involvement = actualJson.involvement;
    assertTrue(involvement instanceof ImmutableInvolvement.Json);
    assertNull(((ImmutableInvolvement.Json) involvement).employeeId);
    assertNull(((ImmutableInvolvement.Json) involvement).provenance);
    assertNull(((ImmutableInvolvement.Json) involvement).entityReference);
    assertNull(actualJson.application);
    assertEquals(0L, ((ImmutableInvolvement.Json) involvement).kindId);
    assertFalse(((ImmutableInvolvement.Json) involvement).isReadOnly);
    assertFalse(((ImmutableInvolvement.Json) involvement).isReadOnlyIsSet);
    assertFalse(((ImmutableInvolvement.Json) involvement).kindIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableApplicationInvolvement.Json#involvement()}
   */
  @Test
  void testJsonInvolvement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableApplicationInvolvement.Json()).involvement());
  }
}
