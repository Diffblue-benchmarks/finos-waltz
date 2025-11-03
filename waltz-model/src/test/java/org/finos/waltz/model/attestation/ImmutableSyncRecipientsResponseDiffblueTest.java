package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse.Builder;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSyncRecipientsResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SyncRecipientsResponse)}.
   * <ul>
   *   <li>Then builder build recipientsCreatedCount longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SyncRecipientsResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SyncRecipientsResponse); then builder build recipientsCreatedCount longValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SyncRecipientsResponse)"})
  void testBuilderFrom_thenBuilderBuildRecipientsCreatedCountLongValueIsThree() {
    // Arrange
    Builder builderResult = ImmutableSyncRecipientsResponse.builder();
    SyncRecipientsResponse instance = mock(SyncRecipientsResponse.class);
    when(instance.recipientsCreatedCount()).thenReturn(3L);
    when(instance.recipientsRemovedCount()).thenReturn(3L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).recipientsCreatedCount();
    verify(instance).recipientsRemovedCount();
    ImmutableSyncRecipientsResponse buildResult = builderResult.build();
    assertEquals(3L, buildResult.recipientsCreatedCount().longValue());
    assertEquals(3L, buildResult.recipientsRemovedCount().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#recipientsCreatedCount(Long)}.
   * <p>
   * Method under test: {@link Builder#recipientsCreatedCount(Long)}
   */
  @Test
  @DisplayName("Test Builder recipientsCreatedCount(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recipientsCreatedCount(Long)"})
  void testBuilderRecipientsCreatedCount() {
    // Arrange
    Builder builderResult = ImmutableSyncRecipientsResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recipientsCreatedCount(3L));
  }

  /**
   * Test Builder {@link Builder#recipientsRemovedCount(Long)}.
   * <p>
   * Method under test: {@link Builder#recipientsRemovedCount(Long)}
   */
  @Test
  @DisplayName("Test Builder recipientsRemovedCount(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recipientsRemovedCount(Long)"})
  void testBuilderRecipientsRemovedCount() {
    // Arrange
    Builder builderResult = ImmutableSyncRecipientsResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recipientsRemovedCount(3L));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRecipientsCreatedCount(Long)}
   *   <li>{@link Json#setRecipientsRemovedCount(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRecipientsCreatedCount(Long)",
      "void Json.setRecipientsRemovedCount(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRecipientsCreatedCount(3L);
    actualJson.setRecipientsRemovedCount(3L);

    // Assert
    assertEquals(3L, actualJson.recipientsCreatedCount.longValue());
    assertEquals(3L, actualJson.recipientsRemovedCount.longValue());
  }

  /**
   * Test Json {@link Json#recipientsCreatedCount()}.
   * <p>
   * Method under test: {@link Json#recipientsCreatedCount()}
   */
  @Test
  @DisplayName("Test Json recipientsCreatedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.recipientsCreatedCount()"})
  void testJsonRecipientsCreatedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recipientsCreatedCount());
  }

  /**
   * Test Json {@link Json#recipientsRemovedCount()}.
   * <p>
   * Method under test: {@link Json#recipientsRemovedCount()}
   */
  @Test
  @DisplayName("Test Json recipientsRemovedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.recipientsRemovedCount()"})
  void testJsonRecipientsRemovedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recipientsRemovedCount());
  }
}
