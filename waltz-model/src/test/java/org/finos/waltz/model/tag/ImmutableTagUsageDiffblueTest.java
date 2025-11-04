package org.finos.waltz.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.WaltzEntity;
import org.junit.jupiter.api.Test;

class ImmutableTagUsageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableTagUsage#builder()}
   *   <li>{@link ImmutableTagUsage#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableTagUsage#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableTagUsage.Builder actualBuilderResult = ImmutableTagUsage.builder();
    ImmutableTagUsage.Builder actualCreatedAtResult = actualBuilderResult
        .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualCreatedAtResult, actualCreatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutableTagUsage.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTagUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableTagUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#from(WaltzEntity)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableTagUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#from(WaltzEntity)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#from(TagUsage)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();
    TagUsage instance = mock(TagUsage.class);
    when(instance.tagId()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).provenance();
    verify(instance).tagId();
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#from(TagUsage)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();
    TagUsage instance = mock(TagUsage.class);
    when(instance.tagId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableTagUsage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).tagId();
    ImmutableTagUsage buildResult = builderResult.build();
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.tagId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Builder#tagId(long)}
   */
  @Test
  void testBuilderTagId() {
    // Arrange
    ImmutableTagUsage.Builder builderResult = ImmutableTagUsage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tagId(1L));
  }

  /**
   * Method under test: {@link ImmutableTagUsage#copyOf(TagUsage)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TagUsage instance = mock(TagUsage.class);
    when(instance.tagId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableTagUsage actualCopyOfResult = ImmutableTagUsage.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).tagId();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.tagId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTagUsage.Json()).createdAt());
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Json#createdBy()}
   */
  @Test
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTagUsage.Json()).createdBy());
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTagUsage.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableTagUsage.Json}
   *   <li>{@link ImmutableTagUsage.Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link ImmutableTagUsage.Json#setCreatedBy(String)}
   *   <li>{@link ImmutableTagUsage.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableTagUsage.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableTagUsage.Json actualJson = new ImmutableTagUsage.Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    actualJson.setEntityReference(null);
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTagUsage.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Json#setTagId(long)}
   */
  @Test
  void testJsonSetTagId() {
    // Arrange
    ImmutableTagUsage.Json json = new ImmutableTagUsage.Json();

    // Act
    json.setTagId(1L);

    // Assert
    assertEquals(1L, json.tagId);
    assertTrue(json.tagIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Json#setTagId(long)}
   */
  @Test
  void testJsonSetTagId2() {
    // Arrange
    ImmutableTagUsage.Json json = new ImmutableTagUsage.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setTagId(1L);

    // Assert
    assertEquals(1L, json.tagId);
    assertTrue(json.tagIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableTagUsage.Json#tagId()}
   */
  @Test
  void testJsonTagId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTagUsage.Json()).tagId());
  }
}
