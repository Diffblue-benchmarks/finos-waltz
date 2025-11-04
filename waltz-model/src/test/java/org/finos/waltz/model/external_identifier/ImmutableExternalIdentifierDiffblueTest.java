package org.finos.waltz.model.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.WaltzEntity;
import org.junit.jupiter.api.Test;

class ImmutableExternalIdentifierDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableExternalIdentifier.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableExternalIdentifier.Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableExternalIdentifier.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableExternalIdentifier.Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableExternalIdentifier.Builder#from(WaltzEntity)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableExternalIdentifier.Builder builderResult = ImmutableExternalIdentifier.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableExternalIdentifier.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableExternalIdentifier.Builder#from(WaltzEntity)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableExternalIdentifier.Builder builderResult = ImmutableExternalIdentifier.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableExternalIdentifier.Builder#from(ExternalIdentifier)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableExternalIdentifier.Builder builderResult = ImmutableExternalIdentifier.builder();
    ExternalIdentifier instance = mock(ExternalIdentifier.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.system()).thenReturn("System");
    when(instance.externalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).externalId();
    verify(instance).system();
  }

  /**
   * Method under test:
   * {@link ImmutableExternalIdentifier.Builder#from(ExternalIdentifier)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableExternalIdentifier.Builder builderResult = ImmutableExternalIdentifier.builder();
    ExternalIdentifier instance = mock(ExternalIdentifier.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.system()).thenReturn("System");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableExternalIdentifier.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).externalId();
    verify(instance).system();
    ImmutableExternalIdentifier buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("System", buildResult.system());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableExternalIdentifier.Builder#system(String)}
   */
  @Test
  void testBuilderSystem() {
    // Arrange
    ImmutableExternalIdentifier.Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.system("System"));
  }

  /**
   * Method under test:
   * {@link ImmutableExternalIdentifier#copyOf(ExternalIdentifier)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ExternalIdentifier instance = mock(ExternalIdentifier.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.system()).thenReturn("System");
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableExternalIdentifier actualCopyOfResult = ImmutableExternalIdentifier.copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).externalId();
    verify(instance).system();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("System", actualCopyOfResult.system());
  }

  /**
   * Method under test:
   * {@link ImmutableExternalIdentifier#fromJson(ImmutableExternalIdentifier.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableExternalIdentifier.Json json = new ImmutableExternalIdentifier.Json();
    json.setExternalId("42");
    json.setSystem("entityReference");
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableExternalIdentifier actualFromJsonResult = ImmutableExternalIdentifier.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.externalId());
    assertEquals("entityReference", actualFromJsonResult.system());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableExternalIdentifier.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableExternalIdentifier.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableExternalIdentifier.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableExternalIdentifier.Json()).externalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableExternalIdentifier.Json}
   *   <li>
   * {@link ImmutableExternalIdentifier.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableExternalIdentifier.Json#setExternalId(String)}
   *   <li>{@link ImmutableExternalIdentifier.Json#setSystem(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableExternalIdentifier.Json actualJson = new ImmutableExternalIdentifier.Json();
    actualJson.setEntityReference(null);
    actualJson.setExternalId("42");
    actualJson.setSystem("System");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("System", actualJson.system);
    assertNull(actualJson.entityReference);
  }

  /**
   * Method under test: {@link ImmutableExternalIdentifier.Json#system()}
   */
  @Test
  void testJsonSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableExternalIdentifier.Json()).system());
  }
}
