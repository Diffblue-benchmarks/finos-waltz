package org.finos.waltz.test_common.helpers;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog.Builder;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChangeLogHelperDiffblueTest {
  @InjectMocks private ChangeLogHelper changeLogHelper;

  @Mock private ChangeLogService changeLogService;

  /**
   * Test {@link ChangeLogHelper#assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference,
   * Operation)}.
   *
   * <p>Method under test: {@link
   * ChangeLogHelper#assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)}
   */
  @Test
  @DisplayName(
      "Test assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogHelper.assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)"
  })
  void testAssertChangeLogContainsAtLeastOneMatchingOperation() {
    // Arrange
    ArrayList<ChangeLog> changeLogList = new ArrayList<>();

    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogList.add(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());
    when(changeLogService.findByParentReference(
            Mockito.<EntityReference>any(),
            Mockito.<Optional<Date>>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(changeLogList);

    // Act
    changeLogHelper.assertChangeLogContainsAtLeastOneMatchingOperation(null, Operation.ADD);

    // Assert
    verify(changeLogService)
        .findByParentReference(isNull(), isA(Optional.class), isA(Optional.class));
  }
}
