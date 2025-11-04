package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableLatestMeasurableAttestationInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLatestMeasurableAttestationInfo#builder()}
   *   <li>{@link ImmutableLatestMeasurableAttestationInfo#attestedAt(Timestamp)}
   *   <li>{@link ImmutableLatestMeasurableAttestationInfo#attestedBy(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableLatestMeasurableAttestationInfo.Builder actualAttestedAtResult = ImmutableLatestMeasurableAttestationInfo
        .builder()
        .attestedAt(mock(Timestamp.class));

    // Assert
    assertSame(actualAttestedAtResult, actualAttestedAtResult.attestedBy("Attested By"));
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#attestationInstanceRef(EntityReference)}
   */
  @Test
  void testBuilderAttestationInstanceRef() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestationInstanceRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#attestationRunRef(EntityReference)}
   */
  @Test
  void testBuilderAttestationRunRef() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestationRunRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#categoryRef(EntityReference)}
   */
  @Test
  void testBuilderCategoryRef() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.categoryRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#dueDate(Date)}
   */
  @Test
  void testBuilderDueDate() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.dueDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#dueDate(java.util.Date)}
   */
  @Test
  void testBuilderDueDate2() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(mock(java.sql.Date.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();
    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.attestationInstanceRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.categoryRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationInstanceRef();
    verify(instance).categoryRef();
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();
    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.attestationRunRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.attestationInstanceRef()).thenReturn(mock(EntityReference.class));
    when(instance.categoryRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).categoryRef();
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();
    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.issuedOn()).thenReturn(fromResult);
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.dueDate()).thenReturn(fromResult2);
    when(instance.attestationRunRef()).thenReturn(mock(EntityReference.class));
    when(instance.attestationInstanceRef()).thenReturn(mock(EntityReference.class));
    when(instance.categoryRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableLatestMeasurableAttestationInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).categoryRef();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    ImmutableLatestMeasurableAttestationInfo buildResult = builderResult.build();
    assertEquals("Attested By", buildResult.attestedBy());
    assertSame(fromResult2, buildResult.dueDate());
    assertSame(fromResult, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();
    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    when(instance.issuedOn()).thenThrow(new IllegalStateException("instance"));
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    when(instance.dueDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.attestationRunRef()).thenReturn(mock(EntityReference.class));
    when(instance.attestationInstanceRef()).thenReturn(mock(EntityReference.class));
    when(instance.categoryRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).categoryRef();
    verify(instance).dueDate();
    verify(instance).issuedOn();
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#from(LatestMeasurableAttestationInfo)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();
    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.issuedOn()).thenReturn(fromResult);
    when(instance.attestedBy()).thenReturn(null);
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.dueDate()).thenReturn(fromResult2);
    when(instance.attestationRunRef()).thenReturn(mock(EntityReference.class));
    when(instance.attestationInstanceRef()).thenReturn(mock(EntityReference.class));
    when(instance.categoryRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableLatestMeasurableAttestationInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).categoryRef();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    ImmutableLatestMeasurableAttestationInfo buildResult = builderResult.build();
    assertNull(buildResult.attestedBy());
    assertSame(fromResult2, buildResult.dueDate());
    assertSame(fromResult, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#issuedOn(Date)}
   */
  @Test
  void testBuilderIssuedOn() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.issuedOn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Builder#issuedOn(java.util.Date)}
   */
  @Test
  void testBuilderIssuedOn2() {
    // Arrange
    ImmutableLatestMeasurableAttestationInfo.Builder builderResult = ImmutableLatestMeasurableAttestationInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.issuedOn(mock(java.sql.Date.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo#copyOf(LatestMeasurableAttestationInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LatestMeasurableAttestationInfo instance = mock(LatestMeasurableAttestationInfo.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.issuedOn()).thenReturn(fromResult);
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(mock(Timestamp.class));
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.dueDate()).thenReturn(fromResult2);
    when(instance.attestationRunRef()).thenReturn(mock(EntityReference.class));
    when(instance.attestationInstanceRef()).thenReturn(mock(EntityReference.class));
    when(instance.categoryRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableLatestMeasurableAttestationInfo actualCopyOfResult = ImmutableLatestMeasurableAttestationInfo
        .copyOf(instance);

    // Assert
    verify(instance).attestationInstanceRef();
    verify(instance).attestationRunRef();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).categoryRef();
    verify(instance).dueDate();
    verify(instance).issuedOn();
    assertEquals("Attested By", actualCopyOfResult.attestedBy());
    assertSame(fromResult2, actualCopyOfResult.dueDate());
    assertSame(fromResult, actualCopyOfResult.issuedOn());
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#attestationInstanceRef()}
   */
  @Test
  void testJsonAttestationInstanceRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLatestMeasurableAttestationInfo.Json()).attestationInstanceRef());
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#attestationRunRef()}
   */
  @Test
  void testJsonAttestationRunRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLatestMeasurableAttestationInfo.Json()).attestationRunRef());
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#attestedAt()}
   */
  @Test
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLatestMeasurableAttestationInfo.Json()).attestedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#attestedBy()}
   */
  @Test
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLatestMeasurableAttestationInfo.Json()).attestedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#categoryRef()}
   */
  @Test
  void testJsonCategoryRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLatestMeasurableAttestationInfo.Json()).categoryRef());
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLatestMeasurableAttestationInfo.Json()).dueDate());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableLatestMeasurableAttestationInfo.Json}
   *   <li>
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#setAttestationInstanceRef(EntityReference)}
   *   <li>
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#setAttestationRunRef(EntityReference)}
   *   <li>
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#setAttestedAt(Timestamp)}
   *   <li>
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#setAttestedBy(String)}
   *   <li>
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#setCategoryRef(EntityReference)}
   *   <li>{@link ImmutableLatestMeasurableAttestationInfo.Json#setDueDate(Date)}
   *   <li>{@link ImmutableLatestMeasurableAttestationInfo.Json#setIssuedOn(Date)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableLatestMeasurableAttestationInfo.Json actualJson = new ImmutableLatestMeasurableAttestationInfo.Json();
    actualJson.setAttestationInstanceRef(null);
    actualJson.setAttestationRunRef(null);
    actualJson.setAttestedAt(mock(Timestamp.class));
    actualJson.setAttestedBy("Attested By");
    actualJson.setCategoryRef(null);
    actualJson.setDueDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualJson.setIssuedOn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("Attested By", actualJson.attestedBy);
    assertNull(actualJson.attestationInstanceRef);
    assertNull(actualJson.attestationRunRef);
    assertNull(actualJson.categoryRef);
  }

  /**
   * Method under test:
   * {@link ImmutableLatestMeasurableAttestationInfo.Json#issuedOn()}
   */
  @Test
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLatestMeasurableAttestationInfo.Json()).issuedOn());
  }
}
