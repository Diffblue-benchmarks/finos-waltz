package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSyncRecipientsResponseDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSyncRecipientsResponse.Builder#from(SyncRecipientsResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSyncRecipientsResponse.Builder builderResult = ImmutableSyncRecipientsResponse.builder();
    SyncRecipientsResponse instance = mock(SyncRecipientsResponse.class);
    when(instance.recipientsCreatedCount()).thenReturn(3L);
    when(instance.recipientsRemovedCount()).thenReturn(3L);

    // Act
    ImmutableSyncRecipientsResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).recipientsCreatedCount();
    verify(instance).recipientsRemovedCount();
    ImmutableSyncRecipientsResponse buildResult = builderResult.build();
    assertEquals(3L, buildResult.recipientsCreatedCount().longValue());
    assertEquals(3L, buildResult.recipientsRemovedCount().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSyncRecipientsResponse.Builder#recipientsCreatedCount(Long)}
   */
  @Test
  void testBuilderRecipientsCreatedCount() {
    // Arrange
    ImmutableSyncRecipientsResponse.Builder builderResult = ImmutableSyncRecipientsResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recipientsCreatedCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableSyncRecipientsResponse.Builder#recipientsRemovedCount(Long)}
   */
  @Test
  void testBuilderRecipientsRemovedCount() {
    // Arrange
    ImmutableSyncRecipientsResponse.Builder builderResult = ImmutableSyncRecipientsResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recipientsRemovedCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableSyncRecipientsResponse#copyOf(SyncRecipientsResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SyncRecipientsResponse instance = mock(SyncRecipientsResponse.class);
    when(instance.recipientsCreatedCount()).thenReturn(3L);
    when(instance.recipientsRemovedCount()).thenReturn(3L);

    // Act
    ImmutableSyncRecipientsResponse actualCopyOfResult = ImmutableSyncRecipientsResponse.copyOf(instance);

    // Assert
    verify(instance).recipientsCreatedCount();
    verify(instance).recipientsRemovedCount();
    assertEquals(3L, actualCopyOfResult.recipientsCreatedCount().longValue());
    assertEquals(3L, actualCopyOfResult.recipientsRemovedCount().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSyncRecipientsResponse#fromJson(ImmutableSyncRecipientsResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSyncRecipientsResponse.Json json = new ImmutableSyncRecipientsResponse.Json();
    json.setRecipientsCreatedCount(1L);
    json.setRecipientsRemovedCount(1L);

    // Act
    ImmutableSyncRecipientsResponse actualFromJsonResult = ImmutableSyncRecipientsResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.recipientsCreatedCount().longValue());
    assertEquals(1L, actualFromJsonResult.recipientsRemovedCount().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSyncRecipientsResponse.Json}
   *   <li>
   * {@link ImmutableSyncRecipientsResponse.Json#setRecipientsCreatedCount(Long)}
   *   <li>
   * {@link ImmutableSyncRecipientsResponse.Json#setRecipientsRemovedCount(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSyncRecipientsResponse.Json actualJson = new ImmutableSyncRecipientsResponse.Json();
    actualJson.setRecipientsCreatedCount(3L);
    actualJson.setRecipientsRemovedCount(3L);

    // Assert
    assertEquals(3L, actualJson.recipientsCreatedCount.longValue());
    assertEquals(3L, actualJson.recipientsRemovedCount.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSyncRecipientsResponse.Json#recipientsCreatedCount()}
   */
  @Test
  void testJsonRecipientsCreatedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSyncRecipientsResponse.Json()).recipientsCreatedCount());
  }

  /**
   * Method under test:
   * {@link ImmutableSyncRecipientsResponse.Json#recipientsRemovedCount()}
   */
  @Test
  void testJsonRecipientsRemovedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSyncRecipientsResponse.Json()).recipientsRemovedCount());
  }
}
