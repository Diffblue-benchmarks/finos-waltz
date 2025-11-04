package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelKindStatDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Builder#from(LegalEntityRelKindStat)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Builder builderResult = ImmutableLegalEntityRelKindStat.builder();
    LegalEntityRelKindStat instance = mock(LegalEntityRelKindStat.class);
    when(instance.legalEntityCount()).thenReturn(3);
    when(instance.relationshipCount()).thenReturn(3);
    when(instance.targetEntityCount()).thenReturn(3);
    when(instance.relKindId()).thenReturn(1L);

    // Act
    ImmutableLegalEntityRelKindStat.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).legalEntityCount();
    verify(instance).relKindId();
    verify(instance).relationshipCount();
    verify(instance).targetEntityCount();
    ImmutableLegalEntityRelKindStat buildResult = builderResult.build();
    assertEquals(1L, buildResult.relKindId());
    assertEquals(3, buildResult.legalEntityCount());
    assertEquals(3, buildResult.relationshipCount());
    assertEquals(3, buildResult.targetEntityCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Builder#legalEntityCount(int)}
   */
  @Test
  void testBuilderLegalEntityCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Builder#relKindId(long)}
   */
  @Test
  void testBuilderRelKindId() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relKindId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Builder#relationshipCount(int)}
   */
  @Test
  void testBuilderRelationshipCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Builder#targetEntityCount(int)}
   */
  @Test
  void testBuilderTargetEntityCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat#copyOf(LegalEntityRelKindStat)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntityRelKindStat instance = mock(LegalEntityRelKindStat.class);
    when(instance.legalEntityCount()).thenReturn(3);
    when(instance.relationshipCount()).thenReturn(3);
    when(instance.targetEntityCount()).thenReturn(3);
    when(instance.relKindId()).thenReturn(1L);

    // Act
    ImmutableLegalEntityRelKindStat actualCopyOfResult = ImmutableLegalEntityRelKindStat.copyOf(instance);

    // Assert
    verify(instance).legalEntityCount();
    verify(instance).relKindId();
    verify(instance).relationshipCount();
    verify(instance).targetEntityCount();
    assertEquals(1L, actualCopyOfResult.relKindId());
    assertEquals(3, actualCopyOfResult.legalEntityCount());
    assertEquals(3, actualCopyOfResult.relationshipCount());
    assertEquals(3, actualCopyOfResult.targetEntityCount());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Json#legalEntityCount()}
   */
  @Test
  void testJsonLegalEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelKindStat.Json()).legalEntityCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLegalEntityRelKindStat.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLegalEntityRelKindStat.Json actualJson = new ImmutableLegalEntityRelKindStat.Json();

    // Assert
    assertEquals(0, actualJson.legalEntityCount);
    assertEquals(0, actualJson.relationshipCount);
    assertEquals(0, actualJson.targetEntityCount);
    assertEquals(0L, actualJson.relKindId);
    assertFalse(actualJson.legalEntityCountIsSet);
    assertFalse(actualJson.relKindIdIsSet);
    assertFalse(actualJson.relationshipCountIsSet);
    assertFalse(actualJson.targetEntityCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelKindStat.Json#relKindId()}
   */
  @Test
  void testJsonRelKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelKindStat.Json()).relKindId());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Json#relationshipCount()}
   */
  @Test
  void testJsonRelationshipCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelKindStat.Json()).relationshipCount());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Json#setLegalEntityCount(int)}
   */
  @Test
  void testJsonSetLegalEntityCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Json json = new ImmutableLegalEntityRelKindStat.Json();

    // Act
    json.setLegalEntityCount(3);

    // Assert
    assertEquals(3, json.legalEntityCount);
    assertTrue(json.legalEntityCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Json#setRelKindId(long)}
   */
  @Test
  void testJsonSetRelKindId() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Json json = new ImmutableLegalEntityRelKindStat.Json();

    // Act
    json.setRelKindId(1L);

    // Assert
    assertEquals(1L, json.relKindId);
    assertTrue(json.relKindIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Json#setRelationshipCount(int)}
   */
  @Test
  void testJsonSetRelationshipCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Json json = new ImmutableLegalEntityRelKindStat.Json();

    // Act
    json.setRelationshipCount(3);

    // Assert
    assertEquals(3, json.relationshipCount);
    assertTrue(json.relationshipCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Json#setTargetEntityCount(int)}
   */
  @Test
  void testJsonSetTargetEntityCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat.Json json = new ImmutableLegalEntityRelKindStat.Json();

    // Act
    json.setTargetEntityCount(3);

    // Assert
    assertEquals(3, json.targetEntityCount);
    assertTrue(json.targetEntityCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelKindStat.Json#targetEntityCount()}
   */
  @Test
  void testJsonTargetEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelKindStat.Json()).targetEntityCount());
  }
}
